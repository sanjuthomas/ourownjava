package com.ourownjava.corejava.util;

/**
 * 
 * @author ourownjava.com
 * 
 */
public class CustomClassLoader extends ClassLoader {

	/**
	 * Override the loadClass method and delegate the responsibility to load the
	 * class to it's super class. If the parent class loader is not able to load
	 * the class then this class loader shall try to load the class by itself.
	 * 
	 */
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {

		Class<?> clazz = super.loadClass(name);

		return clazz;
	}

}
