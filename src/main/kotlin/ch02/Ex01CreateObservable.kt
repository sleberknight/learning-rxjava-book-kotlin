package ch02

import io.reactivex.Observable


fun main(args: Array<String>) {

    val source = Observable.create<String> { emitter ->
        emitter.onNext("Alpha")
        emitter.onNext("Beta")
        emitter.onNext("Gamme")
        emitter.onNext("Delta")
        emitter.onNext("Epsilon")
        emitter.onComplete()
    }

    source.subscribe { println("Received: $it") }
}
