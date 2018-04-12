package learning.rxjava.ch04

import io.reactivex.Observable
import io.reactivex.Observable.interval
import io.reactivex.functions.BiFunction
import java.time.LocalTime
import java.util.concurrent.TimeUnit


fun main(args: Array<String>) {

    val greekLetters = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
    val seconds = interval(1, TimeUnit.SECONDS)

    Observable.zip(greekLetters, seconds, BiFunction { letter: String, _: Long -> letter })
            .subscribe { println("Received $it at ${LocalTime.now()}") }

    TimeUnit.SECONDS.sleep(6)
}