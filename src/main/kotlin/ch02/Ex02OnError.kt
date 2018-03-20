package ch02

import io.reactivex.Observable
import java.util.concurrent.ThreadLocalRandom


fun main(args: Array<String>) {

    val source = Observable.create<String> { emitter ->
        try {
            emitter.onNext("Alpha")
            emitter.onNext("Beta")
            emitter.onNext("Gamme")
            emitter.onNext("Delta")
            if (ThreadLocalRandom.current().nextBoolean()) throw RuntimeException("oops")
            emitter.onNext("Epsilon")
            emitter.onComplete()
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }

    source.subscribe(
            { println("Received: $it") },
            { t ->
                println("Received error: ${t.message}")
                t.printStackTrace()
            }
    )
}