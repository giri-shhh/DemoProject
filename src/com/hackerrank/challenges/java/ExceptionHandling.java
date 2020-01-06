package com.hackerrank.challenges.java;

import java.util.Scanner;

public class ExceptionHandling {
	
	public static void main(String[] args) {
		try(Scanner scan =  new Scanner(System.in)) {
			int n1 = scan.nextInt();
			int n2 = scan.nextInt();
			System.out.println(n1/n2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
