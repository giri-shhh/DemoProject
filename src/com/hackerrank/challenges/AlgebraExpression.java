package com.hackerrank.challenges;

import java.util.Scanner;

public class AlgebraExpression {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			for (int i = 0; i < t; i++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				int n = scanner.nextInt();
				int result;
				for (int j = 0; j < n; j++) {
					result = (int) (a + Math.pow(b, j) * b);
					System.out.print(result + " ");
				}
				System.out.println();
			}
		}
	}
}
