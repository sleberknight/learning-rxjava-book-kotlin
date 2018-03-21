package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma", "Theta", "Delta")
            .distinctUntilChanged(String::length)
            .subscribe { println("Received: $it") }

}