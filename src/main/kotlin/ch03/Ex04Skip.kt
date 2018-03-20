package ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.range(1, 100)
            .skip(90)
            .subscribe { println("Received: $it") }

}