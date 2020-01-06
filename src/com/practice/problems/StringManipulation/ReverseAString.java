package com.practice.problems.StringManipulation;

public class ReverseAString {

	public static void main(String[] args) {
		
		char[] str = "Hello World".toCharArray();
		char[] rev = new char[str.length];
		for(int i=0; i<str.length; i++) {
			rev[i] = str[str.length-1-i];
		}
		
		System.out.println(new String(rev));
	}

}
