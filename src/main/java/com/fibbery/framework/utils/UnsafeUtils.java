package com.fibbery.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.*;

/**
 * unsafe��ħ��
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
	 * ���،�����õăȴ��С
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
	 * Ϊ����ȷ���ڴ��ַʹ��,���з��ŵ�intǿ��ת�����޷��ŵ�long
	 * @param value
	 * @return
	 */
	private static long normalize(int value) {
	    if(value >= 0) return value;
	    return (~0L >>> 32) & value;
	}
	
	/**
	 * ���،������ڵăȴ��ַ
	 * @param obj
	 * @return
	 */
	public static long toAddress(Object obj){
		Object[] arry = new Object[]{obj};
		//��ȡ��һ��Ԫ�ص�ƫ�Ƶ�ַ
		long baseOffset = getUnsafe().arrayBaseOffset(Object[].class);
		return normalize(getUnsafe().getInt(arry, baseOffset));	
	}
	
	/**
	 * ���ڴ��ַ��ȡ����
	 * @param address
	 */
	public static Object fromAddress(long address){
		Object[] array = new Object[]{null};
		//��ȡ��һ��Ԫ�ص�ƫ�Ƶ�ַ
		long baseOffset = getUnsafe().arrayBaseOffset(Object[].class);
		getUnsafe().putLong(array, baseOffset, address);
		return array[0];
	}
	
	/**
	 * ǳ����
	 * @param obj
	 * @return
	 */
	public static Object shallowCopy(Object obj){
		long size = sizeOf(obj);
		//����һ��size��С���ڴ��ַ,���ҷ���λ��
		long address = getUnsafe().allocateMemory(size);
		long start = toAddress(obj);
		getUnsafe().copyMemory(start,address,size);
		return fromAddress(address);
	}
	
	/**
	 * ����String������,��Ϊ������û�����������ַ������������һ������һ�����ڴ��б��棬��ɾ���ö���ֻ��ִ�н�����õĲ��������ǣ����������Ȼ���ڴ��У���GC������ʱ����ִ�������
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
