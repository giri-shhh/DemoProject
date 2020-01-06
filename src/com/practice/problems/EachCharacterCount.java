package com.practice.problems;

import java.util.stream.Collectors;

public class EachCharacterCount {
	
	public static void main(String[] args) {
		
		String s = "Hello my name is gorisj";
		
		s.replace(" ", "").chars().mapToObj(i->(char)i).collect(Collectors.groupingBy(v->v, Collectors.counting())).forEach((k,v)->{System.out.println(k + "  "+ v);});
		
	}

	
}
