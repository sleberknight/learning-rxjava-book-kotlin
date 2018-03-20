package ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .distinct { it.length }
            .subscribe { println("Received: $it") }

}