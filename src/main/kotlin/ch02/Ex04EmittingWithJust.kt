package ch02

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .map { it.length }
            .filter { it >= 5 }
            .subscribe { println("Received $it") }

}