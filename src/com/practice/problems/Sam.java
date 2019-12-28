
package com.practice.problems;

import java.util.Scanner;

public class Sam {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			int nextInt = s.nextInt();
			for (int i = 0; i < nextInt; i++) {
				int nextInt2 = s.nextInt();
				int nextInt3 = s.nextInt();

				int[][] a = new int[nextInt2][nextInt3];
				int[][] b = new int[nextInt2][nextInt3];
				int[][] c = new int[nextInt2][nextInt3];

				int count = 0;
				for (int j = 0; j < nextInt2; j++) {
					for (int k = 0; k < nextInt3; k++) {
						a[i][j] = count++;
					}
				}
				count = 0;
				for (int j = 0; j < nextInt2; j++) {
					for (int k = 0; k < nextInt3; k++) {
						a[j][i] = count++;
					}
				}
				for (int j = 0; j < nextInt2; j++) {
					for (int k = 0; k < nextInt3; k++) {
						c[i][j] = a[i][j] + b[i][j];
					}
				}
				int sum = 0;
				for (int j = 0; j < nextInt2; j++) {
					for (int k = 0; k < nextInt3; k++) {
						if (i == j)
							sum++;
					}
				}
				System.out.println(sum);
			}
		}
	}
}
