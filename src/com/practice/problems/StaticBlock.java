package com.practice.problems;

class A {
	static {
		System.out.println("Class A static");
	}

	{
		System.out.println("Class A block");
	}

	public A() {
		System.out.println("Class A constructor");
	}
}

class B extends A {
	static {
		System.out.println("Class B static");
	}

	{
		System.out.println("Class B block");
	}

	public B() {
		System.out.println("Class B constructor");
	}
}

public class StaticBlock extends B {
	public static void main(String[] args) {
		System.out.println("Static Block static start");
		new StaticBlock();
		System.out.println("Static block static end");
	}
}