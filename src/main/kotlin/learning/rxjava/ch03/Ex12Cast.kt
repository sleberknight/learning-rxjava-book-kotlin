package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta")
            .cast(Object::class.java)
            .subscribe { println("Received: $it") }

}