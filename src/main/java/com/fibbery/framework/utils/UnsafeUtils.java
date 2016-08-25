package com.fibbery.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.Unsafe;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;

/**
 * unsafe黑魔法
 * 
 * @author nenghua_jiang
 *
 */

public class UnsafeUtils {

	private static final String String = null;
	private static Logger logger = LoggerFactory.getLogger(UnsafeUtils.class);

	public static Unsafe getUnsafe(){
		
		Field field = null;
		Unsafe unsafe = null;
		try {
			field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			unsafe = (Unsafe) field.get(null);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return unsafe;
	}
	
	/**
	 * 返回對象佔用的內存大小
	 * @param obj
	 * @return
	 */
	public static long sizeOf(Object obj){
		long size = 0;
		HashSet<Field> fields = new HashSet<Field>();
		Class clazz = obj.getClass();
		while( clazz != Object.class){
			for(Field field : clazz.getDeclaredFields()){
				if((field.getModifiers() & Modifier.STATIC) == 0){
					fields.add(field);
				}
			}
			clazz = clazz.getSuperclass();
			
		}
		
		for (Field field : fields) {
			long offset = getUnsafe().objectFieldOffset(field);
			if( offset > size) size = offset;
		}
		
		return (size/8 + 1) * 8;
	}
	
	/**
	 * 为了正确的内存地址使用,将有符号的int强制转换成无符号的long
	 * @param value
	 * @return
	 */
	private static long normalize(int value) {
	    if(value >= 0) return value;
	    return (~0L >>> 32) & value;
	}
	
	/**
	 * 返回對象所在的內存地址
	 * @param obj
	 * @return
	 */
	public static long toAddress(Object obj){
		Object[] arry = new Object[]{obj};
		//获取第一个元素的偏移地址
		long baseOffset = getUnsafe().arrayBaseOffset(Object[].class);
		return normalize(getUnsafe().getInt(arry, baseOffset));	
	}
	
	/**
	 * 从内存地址获取对象
	 * @param address
	 */
	public static Object fromAddress(long address){
		Object[] array = new Object[]{null};
		//获取第一个元素的偏移地址
		long baseOffset = getUnsafe().arrayBaseOffset(Object[].class);
		getUnsafe().putLong(array, baseOffset, address);
		return array[0];
	}
	
	/**
	 * 浅复制
	 * @param obj
	 * @return
	 */
	public static Object shallowCopy(Object obj){
		long size = sizeOf(obj);
		//开辟一个size大小的内存地址,并且返回位置
		long address = getUnsafe().allocateMemory(size);
		long start = toAddress(obj);
		getUnsafe().copyMemory(start,address,size);
		return fromAddress(address);
	}
	
	/**
	 * 隐藏String类密码,因为如果将用户密码检索成字符串，这可以像一个对象一样在内存中保存，而删除该对象只需执行解除引用的操作。但是，这个对象仍然在内存中，由GC决定的时间来执行清除。
	 */
	public static void cleanPassWord(String password) throws Exception{
		String fake = password.replaceAll(".", "?");
		getUnsafe().copyMemory(fake, 0l, null, toAddress(password), sizeOf(password));
		System.out.println(password);
	}
	
	public static byte[] getClassContent(String path) throws Exception{
		File file = new File(path);
		if( file == null || !file.exists()) return new byte[]{0};
		FileInputStream in = new FileInputStream(file);
		byte[] content = new byte[(int)file.length()];
		in.read(content);
		in.close();
		return content;
	}
	
	public static void main(String[] args) {
		String good = "sdfas";
		long address = toAddress(good);
		System.out.println(fromAddress(address));
	}
}
