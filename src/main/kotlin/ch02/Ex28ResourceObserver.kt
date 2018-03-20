package ch02

import io.reactivex.Observable
import io.reactivex.observers.ResourceObserver
import java.util.concurrent.TimeUnit.SECONDS


fun main(args: Array<String>) {

    val source = Observable.interval(1, SECONDS)

    val anObserver = object : ResourceObserver<Long>() {

        override fun onNext(value: Long) {
            println(value)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
        }

        override fun onComplete() {
            println("Done")
        }

    }

    val disposable = source.subscribeWith(anObserver)

    SECONDS.sleep(5)

    println("Disposing...")
    disposable.dispose()

    SECONDS.sleep(3)
}
