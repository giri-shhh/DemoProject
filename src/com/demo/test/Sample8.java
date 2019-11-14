package com.demo.test;

public class Sample8 {

	public static void main(String[] args) {
		String s ="madam";
		String s1 = "";
		char[] charArray = s.toCharArray();
		char[] newArray = new char[charArray.length];
 		for(int i=charArray.length-1, j=0; i>=0; i--, j++) {
 			newArray[j] = charArray[i];
		}
 		System.out.println(new String(newArray));
		
	}
}
