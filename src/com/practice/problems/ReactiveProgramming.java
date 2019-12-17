package com.practice.problems;

import rx.Observable;
import rx.Subscriber;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ReactiveProgramming {

    public static void main(String[] args) {
        List<String> symbols = Arrays.asList("GOOGLE", "APPLE", "MICROSOFT", "INTEL");

        Observable<StockInfo> value = StockExchange.getStockInfo(symbols);

        System.out.println("got observable");

        value.subscribe(new Subscriber<StockInfo>() {
            @Override
            public void onCompleted() {
                System.out.println("DONE");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("oops: " + throwable);
            }

            @Override
            public void onNext(StockInfo stockInfo) {
                System.out.println(stockInfo);
                if (stockInfo.getName().contains("I")) {
                    System.out.println("Thanks no more data");
                    unsubscribe();
                }
            }
        });
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

    public String getName() {
        return name;
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