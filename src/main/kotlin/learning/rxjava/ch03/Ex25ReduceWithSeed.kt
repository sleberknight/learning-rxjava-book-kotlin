package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just(5, 3, 7, 10, 2, 14)
            .reduce { total, next -> total + next }
            .subscribe { println("Sum: $it") }

}