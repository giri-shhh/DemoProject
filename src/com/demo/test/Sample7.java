package com.demo.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample7 {

	public static void main(String[] args) {
		String s = "";
		System.out.println(getSmallestAndLargest(s, 3));
	}

	// 'smallest' must be the lexicographically smallest substring of length 'k'
	// 'largest' must be the lexicographically largest substring of length 'k'
	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";
		List<String> ss = IntStream.range(0, s.length() - k + 1)
				.mapToObj(i -> s.substring(i, i + k))
				.distinct()
				.sorted(String::compareTo)
				.collect(Collectors.toList());
		smallest = ss.get(0);
		largest = ss.get(ss.size() - 1);
		return smallest + "\n" + largest;
	}
}
