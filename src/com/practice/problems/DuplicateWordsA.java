
package com.practice.problems;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.List;

public class DuplicateWordsA {

	public static void main(String[] args) {

		DuplicateWordsA a = new DuplicateWordsA();
		a.run();
	}

	private void run() {

		List<String> list = Arrays.asList("Bread", "bread");

		list.stream()
			.map(String::toLowerCase)
			.collect(groupingBy(s -> s, counting()))
			.forEach(this::extracted);

	}

	private void extracted(String k, Long v) {
		if (v > 1) {
			System.out.print(k);
			System.out.println(" = " + v);
		}
	}
}
