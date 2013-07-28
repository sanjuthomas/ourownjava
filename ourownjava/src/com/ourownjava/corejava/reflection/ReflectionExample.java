package com.ourownjava.corejava.reflection;

import java.lang.reflect.Constructor;
 
/**
 *
 * @author ourownjava.com
 *
 * Invoking constructor using reflection.
 * 
 * Invoking parameterized constructors using java reflection.
 *
 */
 
public class ReflectionExample {
     
    public static void main(String args[]) throws Exception{
         
        Constructor<?> constructor = Class.forName("com.ourownjava.corejava.reflection.Person")
            .getConstructor();
        Object object = constructor.newInstance();
        System.out.println(((Person)object).getSocialSecurityNumber());
        System.out.println(((Person)object).getName());
         
        constructor = Class.forName("com.ourownjava.corejava.reflection.Person")
            .getConstructor(String.class);
        object = constructor.newInstance("ourownjava.com");
        System.out.println(((Person)object).getSocialSecurityNumber());
        System.out.println(((Person)object).getName());
         
        constructor = Class.forName("com.ourownjava.corejava.reflection.Person")
            .getConstructor(Long.class);
        object = constructor.newInstance(90238454L);
        System.out.println(((Person)object).getSocialSecurityNumber());
        System.out.println(((Person)object).getName());
         
        constructor = Class.forName("com.ourownjava.corejava.reflection.Person")
        .getConstructor(Long.class, String.class);
        object = constructor.newInstance(90238454L, "ourownjava.com");
        System.out.println(((Person)object).getSocialSecurityNumber());
        System.out.println(((Person)object).getName());                    
    }
}