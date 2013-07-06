package com.ourownjava.corejava.thread;

import java.lang.Thread.UncaughtExceptionHandler;
/**
 *
 * @author ourownjava.com
 * @date 26th June, 2011
 * Example program to demonstrate the use of UncaughtExceptionHandler
 *
 */


public class UncaughtExceptionHandlerExample {
	public static void main(final String args[]){
		final Worker worker = new Worker();
		worker.setName("worker");
		worker.setUncaughtExceptionHandler(
                      new WorkerThreadUncaughtExceptionHandler());
		worker.start();
	}
}


class WorkerThreadUncaughtExceptionHandler implements UncaughtExceptionHandler{
	
	public void uncaughtException(final Thread t, final Throwable e) {
		System.out.println("Exception in "+t.getName());
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	
}

class Worker extends Thread{
		public void run(){
		System.out.println(100/0);
	}
}
