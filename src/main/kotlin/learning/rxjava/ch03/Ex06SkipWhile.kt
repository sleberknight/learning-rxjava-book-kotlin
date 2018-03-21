package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.range(1, 100)
            .skipWhile { it <= 95 }
            .subscribe { println("Received: $it") }

}