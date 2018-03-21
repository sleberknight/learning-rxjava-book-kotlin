package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .filter { it.length != 5 }
            .subscribe { println("Received: $it") }

}