package com.ourownjava.corejava.reflection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author ourownjava.com
 * 
 * Example program to demonstrate the power of reflection.
 * How to invoke a method in java using reflection.
 * Java method invocation using reflection.
 * Creating an instance of a class using reflection.
 *
 */

public class MethodReflectionBehavior {
	
	@Test
	public void shouldInvokeSumMethodUsingReflection() throws Exception{
		assertEquals(new Integer(3), Invoker.invoke("com.ourownjava.corejava.reflection.Calculator", "sum", 1, 2));
	}
	
	@Test
	public void shouldInvokeMultiplyMethodUsingReflection() throws Exception{
		assertEquals(new Integer(4), Invoker.invoke("com.ourownjava.corejava.reflection.Calculator", "multiply", 2, 2));
	}
}
