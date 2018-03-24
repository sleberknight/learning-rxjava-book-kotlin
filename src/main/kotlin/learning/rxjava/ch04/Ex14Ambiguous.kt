package learning.rxjava.ch04

import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.SECONDS


fun main(args: Array<String>) {

    val source1 = Observable.interval(1, SECONDS)
            .take(2)
            .map { count -> count + 1 }
            .map { elapsed -> "[${thread()}] Source 1: $elapsed seconds" }

    val source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
            .map { count -> (count + 1) * 300 }
            .map { elapsed -> "[${thread()}] Source 2: $elapsed milliseconds" }

    val source3 = Observable.interval(100, TimeUnit.MILLISECONDS)
            .map { count -> (count + 1) * 300 }
            .map { elapsed -> "[${thread()}] Source 3: $elapsed milliseconds" }

    val disposable = Observable.amb(listOf(source1, source2))
            .doOnDispose { println("Disposed...") }
            .subscribe(::println)

    SECONDS.sleep(5)
    disposable.dispose()

    source2.ambWith(source3).subscribe(::println)

    SECONDS.sleep(5)
}

private fun thread(): String = Thread.currentThread().name