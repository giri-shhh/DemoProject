package com.practice.problems.StringManipulation;

public class Interface {

	public static void main(String[] args) {
			B b = new B();
			
			b.get();
			A.print();
			b.print();
	}
}

class B implements A {
	
	public void get() {
		System.out.println("Class get");
	}
	
	public void print() {
		System.out.println("Class print");
	}
	
}

interface A {
	default void get() {
		System.out.println("Interface get");
	}

	static void print() {
		System.out.println("Interface print");
	}
}
