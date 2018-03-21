package ch03

import io.reactivex.Observable
import java.time.LocalDateTime


fun main(args: Array<String>) {

    println("Repeat 2 times")
    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .repeat(2)
            .subscribe { println("Received: $it") }


    val startTime = LocalDateTime.now()
    println("Repeat until 5 seconds from $startTime")
    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .repeatUntil { LocalDateTime.now().isAfter(startTime.plusSeconds(5)) }
            .subscribe { println("Received: $it") }

}