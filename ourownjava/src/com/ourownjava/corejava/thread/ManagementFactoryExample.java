package com.ourownjava.corejava.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;

/**
 * @author ourownjava.com
 * @date 28th June, 2011
 * 
 * Example program to find all live threads in your JVM instance.
 *
 */

public class ManagementFactoryExample {

	public static void main(final String args[]){
		final WorkerThread worker = new WorkerThread();
		worker.setName("workerThread");
		worker.start();
		final ThreadInfo[] threadInfos = ManagementFactory.getThreadMXBean().
		getThreadInfo(ManagementFactory.getThreadMXBean().getAllThreadIds());
		for(final ThreadInfo threadInfo : threadInfos){
			System.out.println(threadInfo.getThreadId());
			System.out.println(threadInfo.getThreadName());
			System.out.println(threadInfo.getThreadState());
		}
		System.out.println("Total number of live threads :"+ManagementFactory.getThreadMXBean().getThreadCount());
	}
}

class WorkerThread extends Thread{
	public void run(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}