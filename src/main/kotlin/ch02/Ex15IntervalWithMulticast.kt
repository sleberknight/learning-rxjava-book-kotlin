package ch02

import io.reactivex.Observable
import java.util.concurrent.TimeUnit.SECONDS


fun main(args: Array<String>) {

    val seconds = Observable.interval(1, SECONDS).publish()

    println("Starting second Observer")
    seconds.subscribe { println("Observer 1: $it") }

    println("Connecting...")
    seconds.connect()

    SECONDS.sleep(5)

    println("Starting second Observer")
    seconds.subscribe { println("Observer 2: $it") }

    SECONDS.sleep(5)

}