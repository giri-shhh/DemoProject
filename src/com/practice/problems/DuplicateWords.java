package com.practice.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateWords {

    public static void main(String[] args) {

        String name = "Bread is a bread";

        var value = Arrays.stream(name.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()));
        System.out.println("collect = " + value);
    }

}
