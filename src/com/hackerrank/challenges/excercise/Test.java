package com.hackerrank.challenges.excercise;

import java.util.List;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Hello hello = new Hello();
        Hello hello1 = new Hello();
        Hello hello2 = new Hello();

        ExecutorService executorService = Executors.newFixedThreadPool(10, Executors.defaultThreadFactory());

        List<Future<Integer>> submit = executorService.invokeAll(List.of(hello, hello1, hello2));

        new Thread(()-> {
            for (Future<Integer> future : submit) {
                Integer integer = null;
                try {
                    integer = future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                System.out.println("integer = " + integer);
            }
        }).start();

        new Thread(new Hello1()).start();
        new Thread(new Hello2()).start();
        executorService.shutdown();
        System.out.println("in main");
    }
}

class Hello implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Inside callback");
        return 10;
    }
}

class Hello1 implements  Runnable{

    @Override
    public void run() {
        System.out.println("Inside Runnable");
    }
}

class Hello2 extends Thread{
    @Override
    public void run() {
        System.out.println("hello inside Thread");
    }
}
