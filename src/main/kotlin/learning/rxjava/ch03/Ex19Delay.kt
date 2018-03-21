package learning.rxjava.ch03

import io.reactivex.Observable
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit.SECONDS


fun main(args: Array<String>) {

    println("Subscribing at ${LocalDateTime.now()}...")

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .delay(3, SECONDS)
            .subscribe { println("Received: $it at ${LocalDateTime.now()}") }

    SECONDS.sleep(5)
}