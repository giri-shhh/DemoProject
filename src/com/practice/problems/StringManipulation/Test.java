package com.practice.problems.StringManipulation;
public class Test {

	 public void foo(String s) {
	 System.out.println("String");
	 }

	 public void foo(int sb){
	 System.out.println("StringBuffer");
	 }

	 public static void main(String[] args) {
		new Test().foo(null);
		String s1 = "abc";
		StringBuffer s2 = new StringBuffer(s1);
		System.out.println(s1.equals(s2.toString()));
	}

}