package com.fibbery.framework.mapper;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadInfoDemo {
	public static void main(String[] args) {
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos =  bean.dumpAllThreads(false, false);
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("ThreadId :" + threadInfo.getThreadId()+", ThreadName : "+ threadInfo.getThreadName());
		}
	}
}
