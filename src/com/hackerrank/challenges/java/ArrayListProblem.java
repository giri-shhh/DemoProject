package com.hackerrank.challenges.java;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayListProblem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		List<List<Integer>> values = readListOfIntegerValues(scanner, scanner.nextInt());
		scanner.nextLine();
		
		IntStream.range(0, scanner.nextInt())
				.mapToObj(i->scanner.nextLine())
				.map(s-> getValueFromList(values, s))
				.forEach(System.out::println);
		
		scanner.close();
	}

	private static List<List<Integer>> readListOfIntegerValues(Scanner scanner, int noOfLines) {
		return IntStream.range(0, noOfLines)
				.mapToObj(i-> scanner.nextLine())
				.map(ArrayListProblem::getListOfIntegers)
				.collect(Collectors.toList());
	}

	private static List<Integer> getListOfIntegers(String s) {
		return Stream.of(s.split(" "))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
	}

	private static String getValueFromList(List<List<Integer>> values, String s) {
		String[] split = s.split(" ");
		int index = Integer.parseInt(split[1]);
		List<Integer> list = values.get(Integer.parseInt(split[0]) - 1);
		if (index >= list.size())
			return "ERROR!";
		return list.get(index).toString();
	}
}
