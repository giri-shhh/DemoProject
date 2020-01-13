package com.practice.problems;

public class RunExp1 implements Runnable {
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().toString());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println("Thread is running..."+ Math.random()+ "  as" + Thread.currentThread());
	}

	public static void main(String args[]) {
		RunExp1 r1 = new RunExp1();
		Thread t1 = new Thread(r1);
		// this will call run() method
		t1.run();
		t1.run();
		t1.start();
		System.out.println("Hello in main");
	}
}