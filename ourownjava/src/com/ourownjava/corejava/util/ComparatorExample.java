package com.ourownjava.corejava.util;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @date 21st June, 2011
 * @author ourownjava.com
 * 
 * Example program to demonstrate the use of comparable and comparator.
 * Use of Comparator with SortedSet Comparable and SortedSet
 * 
 */

public class ComparatorExample {

	public static void main(final String args[]) {
		final ComparatorExample example = new ComparatorExample();
		example.sortString();
		example.sortEmployee();
		example.sortEmployee(new EmployeeNameComparator());
		example.sortDepartment(new DepartmentNameComparator());
		example.sortDepartment();
	}

	private void sortString() {
		System.out.println("ComparatorExample.sortedString()");
		final Set<String> sortedSet = new TreeSet<String>();
		sortedSet.add("India");
		sortedSet.add("United States");
		sortedSet.add("England");
		sortedSet.add("Singapore");

		for (final String str : sortedSet) {
			System.out.println(str);
			;
		}
	}

	private void sortEmployee() {
		System.out.println("ComparatorExample.sortEmployee()");
		final Set<Employee> sortedSet = new TreeSet<Employee>();
		final Employee emp1 = new Employee();
		emp1.setEmployeeId(1L);
		emp1.setFirstName("Sara");
		emp1.setLastName("Thomas");

		final Employee emp2 = new Employee();
		emp2.setEmployeeId(2L);
		emp2.setFirstName("Sen");
		emp2.setLastName("Varghese");

		final Employee emp3 = new Employee();
		emp3.setEmployeeId(3L);
		emp3.setFirstName("Saran");
		emp3.setLastName("Joseph");

		sortedSet.add(emp3);
		sortedSet.add(emp1);
		sortedSet.add(emp2);

		for (final Employee employee : sortedSet) {
			System.out.println(employee);
		}
	}

	private void sortEmployee(final Comparator<Employee> comparator) {
		System.out.println("ComparatorExample.sortEmployee(Comparator)");
		final Set<Employee> sortedSet = new TreeSet<Employee>(comparator);
		final Employee emp1 = new Employee();
		emp1.setEmployeeId(1L);
		emp1.setFirstName("Sara");
		emp1.setLastName("Thomas");

		final Employee emp2 = new Employee();
		emp2.setEmployeeId(2L);
		emp2.setFirstName("Sara");
		emp2.setLastName("Varghese");

		final Employee emp3 = new Employee();
		emp3.setEmployeeId(3L);
		emp3.setFirstName("Saran");
		emp3.setLastName("Joseph");

		final Employee emp4 = new Employee();
		emp4.setEmployeeId(4L);
		emp4.setFirstName("Paul");
		emp4.setLastName("Alexander");

		sortedSet.add(emp3);
		sortedSet.add(emp1);
		sortedSet.add(emp4);
		sortedSet.add(emp2);

		for (final Employee employee : sortedSet) {
			System.out.println(employee);
		}
	}

	private void sortDepartment() {
        System.out.println("ComparatorExample.sortDepartment()");
        final Set<Department> sortedSet = new TreeSet<Department>();
        final Department dep1 = new Department();
		dep1.setDepartmentId(1L);
		dep1.setName("Technology");
		sortedSet.add(dep1);

		final Department dep2 = new Department();
		dep2.setDepartmentId(2L);
		dep2.setName("Operations");
		sortedSet.add(dep2);

		final Department dep3 = new Department();
		dep3.setDepartmentId(3L);
		dep3.setName("Security");
		sortedSet.add(dep3);

		final Department dep4 = new Department();
		dep4.setDepartmentId(4L);
		dep4.setName("Human Resources");
		sortedSet.add(dep4);

		for (final Department department : sortedSet) {
			System.out.println(department.toString());
		}
	}

	private void sortDepartment(Comparator<Department> comparator) {
        System.out.println("ComparatorExample.sortDepartment(Comparator)");
        final Set<Department> sortedSet = new TreeSet<Department>(comparator);
        final Department dep1 = new Department();
		dep1.setDepartmentId(1L);
		dep1.setName("Technology");
		sortedSet.add(dep1);

		final Department dep2 = new Department();
		dep2.setDepartmentId(2L);
		dep2.setName("Operations");
		sortedSet.add(dep2);

		final Department dep3 = new Department();
		dep3.setDepartmentId(3L);
		dep3.setName("Security");
		sortedSet.add(dep3);

		final Department dep4 = new Department();
		dep4.setDepartmentId(4L);
		dep4.setName("Human Resources");
		sortedSet.add(dep4);

		for (final Department department : sortedSet) {
			System.out.println(department.toString());
		}
	}
}

class Employee implements Comparable<Employee> {
	Long employeeId;
	String firstName;
	String lastName;

	public void setEmployeeId(final Long employeeId) {
		this.employeeId = employeeId;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		final StringBuilder builder = new StringBuilder();
		builder.append(this.firstName);
		builder.append(" ");
		builder.append(this.lastName);
		return builder.toString();
	}

	public int compareTo(Employee o) {
		return this.employeeId.compareTo(o.employeeId);
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

}

class Department {
	Long departmentId;
	String name;

	public void setDepartmentId(final Long departmentId) {
		this.departmentId = departmentId;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name
				+ "]";
	}
}

class EmployeeNameComparator implements Comparator<Employee> {

	public int compare(Employee o1, Employee o2) {
		return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
	}

}

class DepartmentNameComparator implements Comparator<Department> {

	public int compare(Department o1, Department o2) {
		return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
	}

}