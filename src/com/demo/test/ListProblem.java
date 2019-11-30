package com.demo.test;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListProblem {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {

			scan.nextLine();
			List<String> asList = Stream.of(scan.nextLine().split(" ")).collect(Collectors.toList());

			int nextInt2 = scan.nextInt();
			for (int i = 0; i < nextInt2; i++) {
				String nextLine2 = scan.nextLine();
				if ("INSERT".equalsIgnoreCase(nextLine2)) {
					String nextLine3 = scan.nextLine();
					String[] split2 = nextLine3.split(" ");
					asList.add(Integer.valueOf(split2[0]), split2[1]);
				} else if ("DELETE".equalsIgnoreCase(nextLine2)) {
					int nextInt3 = scan.nextInt();
					if (scan.hasNextLine())
						scan.nextLine();
					asList.remove(nextInt3);
				}
			}
			System.out.println(asList.stream().collect(Collectors.joining(" ")));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
