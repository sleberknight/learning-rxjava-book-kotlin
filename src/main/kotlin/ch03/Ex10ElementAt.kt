package ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma", "Delta")
            .elementAt(3)
            .subscribe { println("Received: $it") }

}