package com.practice.problems;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateWords {

    public static void main(String[] args) {

        String name = "Bread is a bread";

        String[] s = name.split(" ");
        List<String> strings = Arrays.asList(s);
        strings.stream().collect(Collectors.groupingBy(v->v), Collectors.counting());
    }

}
