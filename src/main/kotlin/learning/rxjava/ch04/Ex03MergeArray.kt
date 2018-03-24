package learning.rxjava.ch04

import io.reactivex.Observable


fun main(args: Array<String>) {

    val source1 = Observable.just("Alpha", "Beta")
    val source2 = Observable.just("Gamma", "Delta")
    val source3 = Observable.just("Epsilon", "Zeta")
    val source4 = Observable.just("Eta", "Theta")
    val source5 = Observable.just("Iota", "Kappa")

    Observable.mergeArray(source1, source2, source3, source4, source5)
            .subscribe { println("Received: $it") }

}