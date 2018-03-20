package ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .take(3)
            .subscribe { println("Received: $it") }

}