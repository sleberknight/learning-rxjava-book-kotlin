package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.range(1, 10_000)
//            .doOnNext { println("Evaluating: $it") }
            .contains(9563)
            .subscribe { containedIn -> println("Contained in range? $containedIn") }

}