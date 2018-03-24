package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .doOnSubscribe { disposable -> println("Subscribing (disposable: $disposable)") }
            .doOnDispose { println("Disposing") }
            .subscribe { println("Received: $it") }

}