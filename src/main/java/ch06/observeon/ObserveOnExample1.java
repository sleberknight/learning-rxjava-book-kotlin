package ch06.observeon;

import static com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class ObserveOnExample1 {

    public static void main(String[] args) {

        Observable.just("WHISKEY/27653/TANGO", "6555/BRAVO", "232352/5675675/FOXTROT")
                .flatMap(s -> Observable.fromArray(s.split("/")))
                .observeOn(Schedulers.computation())
                .filter(s -> s.matches("[0-9]+"))
                .map(Integer::valueOf)
                .reduce((total, next) -> total + next)
                .subscribe(value ->
                        System.out.printf("Received %d on thread %s", value, Thread.currentThread().getName()));

        sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

}
