package com.hackerrank.challenges.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SmallestAndLargestTokenProblem {

	public static void main(String[] args) {
		String s = "";
		System.out.println(getSmallestAndLargest(s));
	}

	// 'smallest' must be the lexicographically smallest substring of length 'k'
	// 'largest' must be the lexicographically largest substring of length 'k'
	private static String getSmallestAndLargest(String s) {
		String smallest;
		String largest;
		List<String> ss = IntStream.range(0, s.length() - 3 + 1)
				.mapToObj(i -> s.substring(i, i + 3))
				.distinct()
				.sorted(String::compareTo)
				.collect(Collectors.toList());
		smallest = ss.get(0);
		largest = ss.get(ss.size() - 1);
		return smallest + "\n" + largest;
	}
}
