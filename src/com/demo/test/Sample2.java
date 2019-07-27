package com.demo.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sample2 {

	public static void main(String[] args) {

		System.out.println("Main " + Thread.currentThread().getName());
		ExecutorService service = Executors.newFixedThreadPool(5);

		Future<String> submit2 = service.submit(() -> {
			System.out.println("Task 1 " + Thread.currentThread().getName());
			Thread.sleep(2000);
			return "Task 1 response";
		});

		Future<String> submit = service.submit(() -> {
			System.out.println("Task 2 " + Thread.currentThread().getName());
			Thread.sleep(4000);
			return "Task 2 response";
		});

		service.submit(() -> {
			try {
				System.out.println(submit2.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});

		service.submit(() -> {
			try {
				System.out.println(submit.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		System.out.println("in " + Thread.currentThread().getName());
		service.shutdown();

	}
}
