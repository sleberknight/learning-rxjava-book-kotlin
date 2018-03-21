package learning.rxjava.ch02

import io.reactivex.Observable


fun main(args: Array<String>) {

    val source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    source.subscribe { println("Observer 1 received: $it") }

    source.subscribe { println("Observer 2 received: $it") }

}