package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .doOnNext { println("Processing: $it") }
            .map(String::length)
            .subscribe { println("Received: $it") }

}