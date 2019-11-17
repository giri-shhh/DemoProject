package com.demo.test;

import java.util.Scanner;

public class HackerRankAlgebraExpression {
	// Practice test online hackerrak
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			int result = 0;
			for (int j = 0; j < n; j++) {
				result = (int) (a + Math.pow(b, j) * b);
				System.out.print(result + " ");
			}
			System.out.println();
		}
		in.close();
	}

}
