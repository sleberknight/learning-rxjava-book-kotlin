package learning.rxjava.ch04

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.TimeUnit.SECONDS


fun main(args: Array<String>) {

    val msInterval: Long = 300
    val secInterval: Long = 1

    val millis = Observable.interval(msInterval, MILLISECONDS)
    val seconds = Observable.interval(secInterval, SECONDS)

    Observable.combineLatest(millis, seconds,
            BiFunction { msCount: Long, secCount: Long ->
                "{ ${elapsed(msCount, msInterval, "ms")} , ${elapsed(secCount, secInterval, "s")} }"
            }
    ).subscribe(::println)

    SECONDS.sleep(4)
}

private fun elapsed(count: Long, interval: Long, unitAbbreviation: String): String =
        "${(count + 1) * interval}$unitAbbreviation"