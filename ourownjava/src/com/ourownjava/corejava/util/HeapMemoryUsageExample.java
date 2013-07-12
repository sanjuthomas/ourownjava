package com.ourownjava.corejava.util;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

/**
 * 
 * @author ourownjava.com
 * @date 28th June, 2011
 * 
 * Example program to find the memory usage of JVM
 * 
 */
public class HeapMemoryUsageExample {
	
	public static void main(String args[]){
		final MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().
			getHeapMemoryUsage();
		
		System.out.println("Allocated memory for JVM :"+heapMemoryUsage.getCommitted());
		System.out.println("Initially requested memory :"+heapMemoryUsage.getInit());
		System.out.println("Maximum memory can be used :"+heapMemoryUsage.getMax());
		System.out.println("Memory used by the JVM :"+heapMemoryUsage.getUsed());
	}
}
