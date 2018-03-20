package ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .filter { it.startsWith("Z") }
            .defaultIfEmpty("None")
            .subscribe(::println)

}