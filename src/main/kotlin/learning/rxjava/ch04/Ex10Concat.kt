package learning.rxjava.ch04

import io.reactivex.Observable


fun main(args: Array<String>) {

    val source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    val source2 = Observable.just("Zeta", "Eta", "Theta")

    println("source1, source2:")
    Observable.concat(source1, source2).subscribe(::println)

    println("source2, source1:")
    Observable.concat(source2, source1).subscribe(::println)

}