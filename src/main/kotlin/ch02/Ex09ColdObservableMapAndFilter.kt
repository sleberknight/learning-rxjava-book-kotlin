package ch02

import io.reactivex.Observable


fun main(args: Array<String>) {

    val source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    source.subscribe { println("Observer 1 received: $it") }

    source.map(String::length)
            .filter { it >= 5 }
            .subscribe { println("Observer 2 received: $it") }
}