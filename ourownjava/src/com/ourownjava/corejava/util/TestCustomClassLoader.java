package com.ourownjava.corejava.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author ourownjava.com
 *
 */
public class TestCustomClassLoader {
	
	private CustomClassLoader customClassLoader;
	
	@Before
	public void setUp(){
		customClassLoader = new CustomClassLoader();
	}
	
	/**
	 * com.ourownjava.corejava.util.ClassToLoad is in class path so the system class loader should load it.
	 * 
	 * @throws ClassNotFoundException
	 */
	@Test
	public void shoudlLoadClassUsingSystemClassLoader() throws ClassNotFoundException{
		final Class<?> clazz = customClassLoader.loadClass("com.ourownjava.corejava.util.ClassToLoad");
		assertNotNull(clazz);
		assertEquals("sun.misc.Launcher$AppClassLoader", clazz.getClassLoader().getClass().getName());
	}
	
	/**
	 * org.sanju.corejava.util.ClassDoesNotExistInClassPath is not in class path, so the custom class loader should load it.
	 * 
	 * @throws ClassNotFoundException
	 */
	@Test
	public void shouldLoadClassUsingCustomClassLoader() throws ClassNotFoundException{
		final Class<?> clazz = customClassLoader.loadClass("org.sanju.corejava.util.ClassDoesNotExistInClassPath");
		assertNotNull(clazz);
		assertEquals("com.ourownjava.corejava.util.CustomClassLoader", clazz.getClassLoader().getClass().getName());
	}

}
