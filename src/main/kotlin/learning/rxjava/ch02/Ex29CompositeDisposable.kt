package learning.rxjava.ch02

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit.SECONDS


fun main(args: Array<String>) {

    val seconds = Observable.interval(1, SECONDS)

    val disposable1 = seconds.subscribe { println("Observer 1: $it") }

    val disposable2 = seconds.subscribe { println("Observer 2: $it") }

    val disposables = CompositeDisposable(disposable1, disposable2)

    SECONDS.sleep(5)

    println("Disposing...")
    disposables.dispose()

    SECONDS.sleep(3)
}