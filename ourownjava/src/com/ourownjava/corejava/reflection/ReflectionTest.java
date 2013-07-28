package com.ourownjava.corejava.reflection;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

/**
 * 
 * @author ourownjava.com
 * 
 */
public class ReflectionTest {

	@Test
	public void shouldInvokeNonParamConstructor() throws NoSuchMethodException,
			SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		final Constructor<?> constructor = Class.forName(
				"com.ourownjava.corejava.reflection.Person").getConstructor();
		final Person person = (Person) constructor.newInstance();
		assertNotNull(person);
		assertNull(person.getName());
		assertNull(person.getSocialSecurityNumber());
	}

	@Test
	public void shouldInvokeStringParamConstructor()
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		final Constructor<?> constructor = Class.forName(
				"com.ourownjava.corejava.reflection.Person").getConstructor(
				String.class);
		final Person person = (Person) constructor
				.newInstance("ourownjava.com");
		assertNotNull(person);
		assertNotNull(person.getName());
		assertNull(person.getSocialSecurityNumber());
		assertEquals("ourownjava.com", person.getName());
	}

	@Test
	public void shouldInvokeLongParamConstructor()
			throws NoSuchMethodException, SecurityException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		final Constructor<?> constructor = Class.forName(
				"com.ourownjava.corejava.reflection.Person").getConstructor(
				Long.class);
		final Person person = (Person) constructor.newInstance(90238454L);
		assertNotNull(person);
		assertNull(person.getName());
		assertNotNull(person.getSocialSecurityNumber());
		assertEquals(90238454L, person.getSocialSecurityNumber().longValue());
	}

	@Test
	public void shouldInvokeTwoParamConstructor() throws NoSuchMethodException,
			SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		final Constructor<?> constructor = Class.forName(
				"com.ourownjava.corejava.reflection.Person").getConstructor(
				Long.class, String.class);
		final Person person = (Person) constructor.newInstance(90238454L,
				"ourownjava.com");
		assertNotNull(person);
		assertNotNull(person.getName());
		assertNotNull(person.getSocialSecurityNumber());
		assertEquals(90238454L, person.getSocialSecurityNumber().longValue());
		assertEquals(90238454L, person.getSocialSecurityNumber().longValue());
	}
}
