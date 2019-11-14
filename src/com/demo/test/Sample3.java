package com.demo.test;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Sample3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double payment = scanner.nextDouble();
		scanner.close();
		NumberFormat usinstance = NumberFormat.getInstance(Locale.US);
		usinstance.setMaximumFractionDigits(2);
		usinstance.setMinimumFractionDigits(2);

		NumberFormat ininstance = NumberFormat.getInstance(Locale.ENGLISH);
		ininstance.setMaximumFractionDigits(2);
		ininstance.setMinimumFractionDigits(2);
		
		NumberFormat chinaInstance = NumberFormat.getInstance(Locale.US);
		chinaInstance.setMaximumFractionDigits(2);
		chinaInstance.setMinimumFractionDigits(2);
		
		NumberFormat franceInstance = NumberFormat.getInstance(Locale.US);
		franceInstance.setMaximumFractionDigits(2);
		franceInstance.setMinimumFractionDigits(2);
		
		String us = "$" + usinstance.format(payment);
		String india = "Rs." + ininstance.format(payment);
		String china = "￥" + NumberFormat.getInstance(Locale.CHINA).format(payment);
		String france = NumberFormat.getInstance(Locale.FRANCE).format(payment) + " €";

		System.out.println("US: " + us);
		System.out.println("India: " + india);
		System.out.println("China: " + china);
		System.out.println("France: " + france);
	}
}