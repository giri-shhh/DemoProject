package com.demo.test;

import static java.util.stream.Collectors.minBy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Java8FunctionsExample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> collect = list.stream()
				.collect(minBy((n1, n2) -> n1.compareTo(n2)));
		Integer orElse = collect.map(i -> i).orElse(1);
		System.out.println(orElse);


	}
}
