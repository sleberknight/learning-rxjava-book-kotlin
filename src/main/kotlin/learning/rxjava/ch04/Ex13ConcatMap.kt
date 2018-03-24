package learning.rxjava.ch04

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .doOnNext(::printNext)
            .concatMap { Observable.fromIterable(it.toCharArray().asIterable()) }
            .subscribe(::printNext)

}

private fun printNext(it: Any?) {
    println("[${Thread.currentThread().name}] Processing $it")
}