package ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just(1, 1, 1, 2, 2, 3, 3, 2, 1, 1)
            .distinctUntilChanged()
            .subscribe { println("Received: $it") }

}