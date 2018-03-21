package learning.rxjava.ch02

import io.reactivex.Observable


fun main(args: Array<String>) {

    val source = Observable.create<String> { emitter ->
        try {
            emitter.onNext("Alpha")
            emitter.onNext("Beta")
            emitter.onNext("Gamme")
            emitter.onNext("Delta")
            emitter.onNext("Epsilon")
            emitter.onComplete()
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }

    val lengths = source.map(String::length)

    val filtered = lengths.filter { length -> length >= 5 }

    filtered.subscribe { println("Received: $it") }

}