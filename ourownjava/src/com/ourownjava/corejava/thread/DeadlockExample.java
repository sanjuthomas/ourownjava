package com.ourownjava.corejava.thread;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.util.Arrays;

/**
 *
 * @author sanju.org
 * @date 13th, August 2011
 *
 * How to find dead lock in java?
 *
 */

public class DeadlockExample {

	public static void main(String args[]){

		Thread deadlockFinder = new DeadlockFinderThread();
		deadlockFinder.setDaemon(true);
		deadlockFinder.start();

		String resource1 = new String("apple");
		String resource2 = new String("orange");
		Thread  thread1 = new Thread(new WorkerThread2(resource1, resource2));
		thread1.setName("thread1");
		thread1.start();
		Thread thread2 = new Thread(new WorkerThread3(resource1, resource2));
		thread2.setName("thread2");
		thread2.start();
	}
}

class DeadlockFinderThread extends Thread{

	@Override
	public void run(){
		while(true){
			long[] ids = ManagementFactory.getThreadMXBean()
				.findDeadlockedThreads();
			if(null != ids){
				ThreadInfo[] threadInfo = ManagementFactory
					.getThreadMXBean().getThreadInfo(ids);
				for(ThreadInfo info : threadInfo){
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

	public WorkerThread2(String resource1, String resource2){
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
			} catch (InterruptedException e) {
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

	public WorkerThread3(String resource1, String resource2){
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
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (resource1) {
				System.out.println("got lock on resource1");
			}
		}
	}
}
