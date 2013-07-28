	package com.ourownjava.corejava.reflection;
	
	/**
	 * 
	 * @author ourownjava.com
	 *
	 */
	public class Person{
	     
	    String name;
	    Long socialSecurityNumber;
	     
	    public Person(){
	        System.out.println("Person.Person()");
	    }
	     
	    public Person(String name){
	        System.out.println("Person.Person(String)");
	        this.name = name;
	    }
	     
	    public Person(Long socialSecurityNumber){
	        System.out.println("Person.Person(Long)");
	        this.socialSecurityNumber = socialSecurityNumber;
	    }
	     
	    public Person(Long empId, String name){
	        System.out.println("Person.Person(Long, String)");
	        this.socialSecurityNumber = empId;
	        this.name = name;
	    }
	 
	    public String getName() {
	        return name;
	    }
	 
	    public Long getSocialSecurityNumber() {
	        return socialSecurityNumber;
	    }  
	}