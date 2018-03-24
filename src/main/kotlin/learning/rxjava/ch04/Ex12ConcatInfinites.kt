package learning.rxjava.ch04

import io.reactivex.Observable
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.TimeUnit.SECONDS


fun main(args: Array<String>) {

    val source1 = Observable.interval(1, SECONDS)
            .take(2)
            .map { count -> count + 1 }
            .map { elapsed -> "[${thread()}] Source 1: $elapsed seconds" }

    val source2 = Observable.interval(300, MILLISECONDS)
            .map { count -> (count + 1) * 300 }
            .map { elapsed -> "[${thread()}] Source 2: $elapsed milliseconds" }

    Observable.concat(source1, source2).subscribe(::println)

    SECONDS.sleep(5)

}

private fun thread(): String = Thread.currentThread().name