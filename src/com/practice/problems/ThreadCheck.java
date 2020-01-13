package com.practice.problems;

public class ThreadCheck {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            print();
        });
        thread.start();
        Thread thread1 = new Thread(() -> {
            new ThreadCheck().print1();
        });
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void print() {
        try {
            System.out.println("inside static");
            Thread.sleep(3000);
            System.out.println("inside static");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void print1() {
        try {
            System.out.println("Inside non static");
            Thread.sleep(1000);
            System.out.println("Inside non static");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
