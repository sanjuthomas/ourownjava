package com.ourownjava.corejava.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;

/**
 *
 * @author ourownjava.com
 * @date 13th, August 2011
 *
 * How to find dead lock in java?
 *
 */

public class DeadlockExample {

	public static void main(final String args[]){

		final Thread deadlockFinder = new DeadlockFinderThread();
		deadlockFinder.setDaemon(true);
		deadlockFinder.start();

		final String resource1 = new String("apple");
		final String resource2 = new String("orange");
		final Thread  thread1 = new Thread(new WorkerThread2(resource1, resource2));
		thread1.setName("thread1");
		thread1.start();
		final Thread thread2 = new Thread(new WorkerThread3(resource1, resource2));
		thread2.setName("thread2");
		thread2.start();
	}
}

class DeadlockFinderThread extends Thread{

	@Override
	public void run(){
		while(true){
			final long[] ids = ManagementFactory.getThreadMXBean()
				.findDeadlockedThreads();
			if(null != ids){
				final ThreadInfo[] threadInfo = ManagementFactory
					.getThreadMXBean().getThreadInfo(ids);
				for(final ThreadInfo info : threadInfo){
					System.out.println(info.getThreadName()
					+" is waiting for "+info.getLockOwnerName());
				}
			}
		}
	}
}

class WorkerThread2 implements Runnable{

	String resource1;
	String resource2;

	public WorkerThread2(final String resource1, final String resource2){
		this.resource1 = resource1;
		this.resource2 = resource2;
	}

	@Override
	public void run(){

		System.out.println("WorkerThread.run()");
		synchronized (resource1) {
			System.out.println("got lock on resource1.. now process resource1");
			try {
				// I am simulating the process using one second sleep
				Thread.sleep(1000);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (resource2) {
				System.out.println("got lock on resource2");
			}
		}

	}
}

class WorkerThread3  implements Runnable{

	String resource1;
	String resource2;

	public WorkerThread3(final String resource1, final String resource2){
		this.resource1 = resource1;
		this.resource2 = resource2;
	}

	@Override
	public void run() {

		System.out.println("WorkerThread1.run()");
		synchronized (resource2) {
			System.out.println("got lock on resource2.. now process resource1");
			try {
				// I am simulating the process using one second sleep
				Thread.sleep(1000);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (resource1) {
				System.out.println("got lock on resource1");
			}
		}
	}
}
