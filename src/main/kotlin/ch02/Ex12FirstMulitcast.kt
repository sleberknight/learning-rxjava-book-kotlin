package ch02

import io.reactivex.Observable
import java.lang.Thread.sleep


fun main(args: Array<String>) {

    val connectableObservable =
            Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                    .publish()

    connectableObservable.subscribe { println("Observer 1: $it") }

    connectableObservable.map { it.length }.subscribe { println("Observer 2: $it") }

    println("Wait for it...")
    sleep(250)

    println("connecting...")
    connectableObservable.connect()
}