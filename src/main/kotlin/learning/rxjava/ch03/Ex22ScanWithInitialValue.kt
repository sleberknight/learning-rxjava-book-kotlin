package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .scan(0) { total, _ -> total + 1 }
            .skip(1)
            .subscribe { println("Running count: $it") }

}