package ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just(5, 3, 7, 11, 2, 14)
            .doOnNext { println("Evaluating: $it") }
            .all { it < 10 }
            .subscribe { allLessThanTen -> println("All less than 10 ? $allLessThanTen") }

}