package com.fibbery.framework.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
	static boolean flag = true;
	static Object lock = new Object();
	
	public static void main(String[] args) {
		Thread wait = new Thread(new WaitThread(),"WaitThread");
		wait.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread notify = new Thread(new NotifyThread(),"NotifyThread");
		notify.start();
	}
	
	static class WaitThread implements Runnable{
		@Override
		public void run() {
			synchronized (lock) {
				while(flag){
					try{
						System.out.println(Thread.currentThread()+" flag is true,wait at "+new SimpleDateFormat().format(new Date()));
						lock.wait();	
					}catch(InterruptedException e){}
					
				}
				
				//条件满足的时候标志完成工作
				System.out.println(Thread.currentThread()+" flag is false,running at "+new SimpleDateFormat().format(new Date()));
			}
		}
		
	}
	
	static class NotifyThread implements Runnable{
		
		@Override
		public void run(){
			synchronized (lock) {
				System.out.println(Thread.currentThread()+"notify at "+ new SimpleDateFormat().format(new Date()));
				flag = false;
				lock.notifyAll();
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//再次加锁
			synchronized (lock) {
				System.out.println(Thread.currentThread()+"hold lock again, relock at " + new SimpleDateFormat().format(new Date()));
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
