package learning.rxjava.ch02

import io.reactivex.Observable
import io.reactivex.functions.Consumer


fun main(args: Array<String>) {

    val source = Observable.just("Alpha", "Beta", "Gamma")

    source.first("I am the default")
            .subscribe(Consumer(::println))
}