package com.fibbery.framework.utils;

import java.util.concurrent.TimeUnit;

public class TimeUtils {
	
	/*storage event start time*/
	private static final ThreadLocal<Long> TIME_LOCAL = new ThreadLocal<Long>() {
		@Override
		protected Long initialValue() {
			return System.currentTimeMillis();
		}
	};
	
	/* 记录开始时间*/
	public static final void begin(){
		TIME_LOCAL.set(System.currentTimeMillis());
	}
	
	/*联动begin,返回耗时*/
	public static final Long end(){
		return System.currentTimeMillis() - TIME_LOCAL.get();
	}
	
	public static void main(String[] args) throws InterruptedException {
		TimeUtils.begin();
		TimeUnit.SECONDS.sleep(4);
		System.out.println("Thread cost:"+TimeUtils.end() +"ms");
	}
}
