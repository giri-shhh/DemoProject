package com.demo.test;

import java.util.List;
import java.util.stream.Collectors;

public class Sample3 {

	public static void main(String[] args) {
		System.out
				.println(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallelStream().map(x -> x).collect(Collectors.toList()));
	}
}
