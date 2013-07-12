package com.ourownjava.corejava.file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

/**
 * 
 * @author ourownjava.com
 * @date August 17th, 2011
 * 
 * Reloading property file without restarting the JVM
 * 
 */
public class ResourceLoadingExample {

	public static void main(String args[]) throws InterruptedException,ConfigurationException {
		//load the property file from file system
		final PropertiesConfiguration property = new PropertiesConfiguration("/home/thosan/java/testfiles/application.properties");
		//set the reloading strategy
		property.setReloadingStrategy(new FileChangedReloadingStrategy());
		
		//starting a thread to make changes in the property file, this is only to test
		final Thread thread = new PropertyFileChangerThread("/home/thosan/java/testfiles/application.properties");
		thread.start();

		//print the changes in file every 6 second, this is only for testing
		while (true) {
			final Iterator<String> i = property.getKeys();
			while (i.hasNext()) {
				System.out.println(i.next());
			}
			Thread.sleep(6000);
		}
	}
}

class PropertyFileChangerThread extends Thread {

	private String fileName;

	PropertyFileChangerThread(String fileName) {
		this.fileName = fileName;
	}

	public void run() {
		try {
			while (true) {
				//open the property file on append mode and write key value pair in every 5 seconds.
				final FileWriter fileWriter = new FileWriter(fileName, true);
				fileWriter.write("\n");
				fileWriter.write(Math.random() + "=" + Math.random());
				fileWriter.flush();
				Thread.sleep(5000);
				fileWriter.close();
			}
		} catch (final IOException e) {
			e.printStackTrace();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}