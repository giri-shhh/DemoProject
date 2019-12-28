package com.practice.problems;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SampleProblem {

	public static void main(String[] args) {

		String l1 = "House,Sector,Block,Tower,Apartment";
		String l2 = "House=8Sector";
		String l3 = "Sector=10Block";
		String l4 = "Block=3Tower";
		String l5 = "Tower=300Apartment";

		List<String> words = Arrays.asList(l1.split(","));

		int[][] array = new int[words.size()][words.size()];

		splitValues(l2, array, words);
		splitValues(l3, array, words);
		splitValues(l4, array, words);
		splitValues(l5, array, words);

		for (int i = 0; i < array.length-1; i++) {
			System.out.print(words.get(i) + "\t");
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < words.size(); i++) {
			if (i < words.size() - 1)
				System.out.print(words.get(i) + " = ");
			else
				System.out.print(words.get(i));
		}
	}

	private static void splitValues(String s, int[][] array, List<String> words) {
		Pattern pattern = Pattern.compile("([a-zA-Z]+)=([0-9]+)([a-zA-Z]+)");

		Matcher matcher = pattern.matcher(s);
		String parent = null;
		String child = null;
		Integer value = null;
		while (matcher.find()) {
			parent = matcher.group(1);
			System.out.println(parent);
			value = Integer.parseInt(matcher.group(2));
			System.out.println(value);
			child = matcher.group(3);
			System.out.println(child);
		}
		array[words.indexOf(parent)][words.indexOf(child)] = value;
	}
}