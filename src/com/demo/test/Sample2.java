package com.demo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample2 {

	public static void main(String[] args) {

		System.out.println("Processors : " + Runtime.getRuntime().availableProcessors());

		System.out.println("Main " + Thread.currentThread().getName());
		ExecutorService service = Executors.newFixedThreadPool(5);

		service.submit(() -> {
			System.out.println("Task 1 " + Thread.currentThread().getName());
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Task 1 response " + Thread.currentThread().getName());
		});

		service.submit(() -> {
			System.out.println("Task 2 " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Task 2 response " + Thread.currentThread().getName());
		});

		System.out.println("in " + Thread.currentThread().getName());
		service.shutdown();
		System.out.println("DONE " + Thread.currentThread().getName());
	}
}
