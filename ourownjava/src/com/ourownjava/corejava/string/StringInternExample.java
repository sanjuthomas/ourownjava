package com.ourownjava.corejava.string;

/**
 * @date 20th, June 2011
 * @author ourownjava.com
 * 
 * To demonstrate the use of intern method in java.lang.String.
 * 
 */
public class StringInternExample {

	public static void main(String args[]) {

		String str = "India";
		String str1 = "India";
		String str2 = new String("India");
		String str3 = new String("India").intern();

		System.out.println("str == str1 : "+(str == str1));
		System.out.println("str == str2 : "+(str == str2));
		System.out.println("str == str3 : "+(str == str3));
	}
}
