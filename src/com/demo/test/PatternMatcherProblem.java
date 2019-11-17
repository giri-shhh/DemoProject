package com.demo.test;

public class PatternMatcherProblem {

	public static void main(String[] args) {
		String s = "hello";
        String[] tokens = s.split("[!,?._'@ ]+");
        if (s.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(tokens.length);
        }
        System.out.println(tokens.length);
        for(String a: tokens) {
            System.out.println(a);
        }
	}
}
