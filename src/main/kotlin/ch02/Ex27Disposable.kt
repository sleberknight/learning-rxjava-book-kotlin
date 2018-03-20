package ch02

import io.reactivex.Observable
import java.util.concurrent.TimeUnit.SECONDS


fun main(args: Array<String>) {

    val seconds = Observable.interval(1, SECONDS)

    val disposable = seconds.subscribe { println("Received $it") }

    SECONDS.sleep(5)

    disposable.dispose()

    println("Disposed? ${disposable.isDisposed}")

    SECONDS.sleep(3)
}