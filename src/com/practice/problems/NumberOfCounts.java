package com.practice.problems;

public class NumberOfCounts {

	public static void main(String[] args) {

		totalCountOfWords();

		occurencesOfCharacters();
	}

	private static void occurencesOfCharacters() {

		String s = "Java is java again java again";

		int val = s.length() - s.replace("a", "").length();

		System.out.println(val);

	}

	private static void totalCountOfWords() {
		String a = "Hello my name is hello name is hello";

		String[] split = a.split(" ");
		System.out.println(split.length);
	}
}
