package com.hackerrank.challenges.java;

import java.util.HashMap;
import java.util.Map;

class Employee implements Comparable<Employee> {

	Employee() {
	}

	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public int compareTo(Employee arg0) {
		return 1;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Final");
		super.finalize();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return super.toString();
	}
}

public class ObjectClassMethodsOverride {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();

		Map<Employee, String> map = new HashMap<>();
		map.put(e1, "A");
		map.put(e2, "B");
		map.put(e3, "C");

		System.out.println(map.size());
		System.out.println(map.get(e2));
		System.gc();
	}

}
