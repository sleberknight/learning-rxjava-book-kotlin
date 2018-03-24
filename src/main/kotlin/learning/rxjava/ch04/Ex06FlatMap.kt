package learning.rxjava.ch04

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .flatMap { Observable.fromIterable(it.toCharArray().asIterable()) }
            .subscribe(::println)

}