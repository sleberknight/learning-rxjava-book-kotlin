package learning.rxjava.ch04

import io.reactivex.Observable
import java.util.concurrent.TimeUnit.SECONDS


fun main(args: Array<String>) {

    val intervalsInSeconds: Observable<Long> = Observable.just(2, 3, 0, 10, -5, 7)

    intervalsInSeconds
            .filter { it > 0 }
            .flatMap { interval ->
                Observable.interval(interval, SECONDS).map { count -> elapsedTimeMessage(interval, count) }
            }.subscribe(::println)

    SECONDS.sleep(21)
}

private fun elapsedTimeMessage(interval: Long, zeroBasedCount: Long): String {
    return "[${thread()}] ${interval}s interval: ${elapsed(interval, zeroBasedCount)} seconds elapsed"
}

private fun thread(): String = Thread.currentThread().name

private fun elapsed(interval: Long, zeroBasedCount: Long): Long = (zeroBasedCount + 1) * interval