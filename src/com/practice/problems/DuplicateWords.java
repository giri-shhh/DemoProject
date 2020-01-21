package com.practice.problems;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateWords {

	public static void main(String[] args) {

		String name = "Bread is a bread";

		Map<Object, Long> value = Arrays.stream(name.split(" "))
				.map(String::toLowerCase)
				.collect(Collectors.groupingBy(v -> v, Collectors.counting()));

		Stream.of("hello", "hi", "hero").dropWhile(p -> p.startsWith("he")).forEach(System.out::println);

		int i = 10;

		System.out.println(i++);
		System.out.println(i);
		System.out.println(i--);
		System.out.println(i);
		System.out.println(++i);
		System.out.println(i);
		System.out.println(--i);
		System.out.println(i);

		System.out.println("collect = " + value);
	}
}
