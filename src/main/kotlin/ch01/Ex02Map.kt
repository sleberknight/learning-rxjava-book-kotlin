package ch01

import io.reactivex.Observable


fun main(args: Array<String>) {

    val myStrings = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
    myStrings.map { it.length }.subscribe { println(it) }

}