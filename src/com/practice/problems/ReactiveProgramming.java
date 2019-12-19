package com.practice.problems;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ReactiveProgramming {

    public static void main(String[] args) throws InterruptedException {
        List<String> symbols = Arrays.asList("GOOGLE", "APPLE", "MICROSOFT", "INTEL");

        Observable<StockInfo> value = StockExchange.getStockInfo(symbols);

        System.out.println("got observable");

        value.subscribeOn(Schedulers.io()).subscribe(x -> {
                    System.out.println("First " + x);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                throwable -> System.out.println("oops: " + throwable),
                () -> System.out.println("DONE")
        );

        value.skip(20).subscribeOn(Schedulers.io()).subscribe(x -> {
                    System.out.println("Second "+ x);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                throwable -> System.out.println("oops: " + throwable),
                () -> System.out.println("DONE")
        );

        Thread.sleep(30000);
    }
}

class StockExchange {
    public static Observable<StockInfo> getStockInfo(List<String> symbols) {
        return Observable.create(subscriber -> processRequest(subscriber, symbols));
    }

    private static void processRequest(Subscriber<? super StockInfo> subscriber, List<String> symbols) {
        while (!subscriber.isUnsubscribed()) {
            symbols.stream()
                    .filter(data -> !subscriber.isUnsubscribed())
                    .map(StockFetcher::fetch)
                    .forEach(subscriber::onNext);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class StockInfo {
    private final String name;
    private final BigDecimal value;

    public StockInfo(String name, BigDecimal value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}

class StockFetcher {
    public static StockInfo fetch(String symbol) {
        return new StockInfo(symbol, BigDecimal.valueOf(Math.random() * 10));
    }
}