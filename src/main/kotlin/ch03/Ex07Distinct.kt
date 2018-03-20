package ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .map { it.length }
            .distinct()
            .subscribe { println("Received: $it") }

}