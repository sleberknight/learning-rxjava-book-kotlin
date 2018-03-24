package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .doOnComplete { println("Source done emitting") }
            .map { it.length }
            .subscribe(::println)

}