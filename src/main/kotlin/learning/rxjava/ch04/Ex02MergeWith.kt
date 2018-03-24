package learning.rxjava.ch04

import io.reactivex.Observable


fun main(args: Array<String>) {

    val source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    val source2 = Observable.just("Zeta", "Eta", "Theta")

    source1.mergeWith(source2).subscribe(::println)
}