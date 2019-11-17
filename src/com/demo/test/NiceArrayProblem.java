package com.demo.test;

import java.util.Arrays;
import java.util.List;

public class NiceArrayProblem {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 7, 8, 9, 0);
		System.out.println(
				numbers.stream().allMatch(an -> numbers.stream().anyMatch(bn -> bn + 1 == an || bn - 1 == an)));
	}
}
