package com.demo.test;

import java.util.Map;
import java.util.stream.Collectors;

public class Sample9 {
	public static void main(String[] args) {
		String a = "anagram";
		String b = "managra";

		Map<Character, Long> collect = a.chars().mapToObj(i->(char)i).collect(Collectors.groupingBy(i->i, Collectors.counting()));
		Map<Character, Long> collect1 = b.chars().mapToObj(i->(char)i).collect(Collectors.groupingBy(i->i, Collectors.counting()));
		
	}
}
