package ch02

import io.reactivex.Observable


fun main(args: Array<String>) {

    val items = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    Observable.fromIterable(items)
            .map { it.length }
            .filter { it >= 5 }
            .subscribe { println("Received: $it") }
}