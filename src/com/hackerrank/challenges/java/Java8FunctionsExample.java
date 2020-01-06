package com.hackerrank.challenges.java;

import java.util.stream.Stream;

public class Java8FunctionsExample {

    public static void main(String[] args) {
		System.out.println(Stream.of(1, 2, 3, 4, 5).min(Integer::compareTo).orElse(1));
    }
}
