package ch02

import io.reactivex.Observable


fun main(args: Array<String>) {

    val onNext = { value: Int -> println("Received: $value") }
    val onError = { t: Throwable -> t.printStackTrace() }
    val onComplete = { println("Done") }

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .map { it.length }
            .filter { it >= 5 }
            .subscribe(onNext, onError, onComplete)

}