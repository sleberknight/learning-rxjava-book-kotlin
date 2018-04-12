package learning.rxjava.ch04

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.TimeUnit.SECONDS


fun main(args: Array<String>) {

    val msPeriod: Long = 300
    val secPeriod: Long = 1

    val millis = Observable.interval(msPeriod, MILLISECONDS)
    val seconds = Observable.interval(secPeriod, SECONDS)

    Observable.combineLatest(millis, seconds,
            BiFunction { msCount: Long, secCount: Long ->
                "{ ${elapsed(msCount, msPeriod, "ms")} , ${elapsed(secCount, secPeriod, "s")} }"
            }
    ).subscribe(::println)

    SECONDS.sleep(4)
}

private fun elapsed(count: Long, period: Long, unitAbbreviation: String): String =
        "${(count + 1) * period}$unitAbbreviation"