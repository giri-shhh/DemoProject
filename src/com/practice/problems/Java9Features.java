package com.practice.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java9Features {

	static List<String> list = Arrays.asList("Aello", "Hi", "Aoooo");

	public static void main(String[] args) {

		list.stream().takeWhile(i -> i.startsWith("A")).forEach(System.out::println);
		list.stream().dropWhile(i -> i.startsWith("A")).forEach(System.out::println);

		List<String> collect = list.stream().collect(Collectors.toUnmodifiableList());

	}
}
