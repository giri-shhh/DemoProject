package com.hackerrank.challenges.java;

import java.util.Scanner;

public class PatternMatcherProblem {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String s = scanner.nextLine();
            String[] tokens = s.split("[!,?._'@ ]+");
            if (s.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(tokens.length);
            }
            System.out.println(tokens.length);
            for (String a : tokens) {
                System.out.println(a);
            }
        }
    }
}
