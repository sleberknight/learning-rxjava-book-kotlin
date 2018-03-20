package ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.range(1, 100)
            .takeWhile { it < 5 }
            .subscribe { println("Received: $it") }

}