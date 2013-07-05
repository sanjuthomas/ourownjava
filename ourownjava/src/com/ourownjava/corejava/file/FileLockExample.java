package com.ourownjava.corejava.file;

import java.io.*;
import java.nio.channels.*;

/**
 * @date 1st May, 2011
 * @author ourownjava.com
 *
 * To demonstrate the file lock API in java.nio
 * Example program for java file lock
 *
 */

public class FileLockExample {

	private FileLock lock(RandomAccessFile file) throws IOException{
		final FileLock fileLock = file.getChannel().tryLock();
		//if the JVM is not able to acquire a lock then a null
		//is returned, it could be because the lock is already acquired
		//by another thread or process.
		return fileLock;
	}

	public static void main(String args[]) throws IOException, InterruptedException{
		final RandomAccessFile file = new RandomAccessFile(new File("/mnt/java/sample.file"), "rw");
		final FileLockExample fthis = new FileLockExample();
		final FileLock lock = fthis.lock(file);
		System.out.println("Got the lock? "+(null != lock));
		if(null == lock){
			return;
		}
		while(true){
			if(null != lock){
				System.out.println("Is a valid lock? "+lock.isValid());
			}
			Thread.sleep(3000);
		}
	}
}