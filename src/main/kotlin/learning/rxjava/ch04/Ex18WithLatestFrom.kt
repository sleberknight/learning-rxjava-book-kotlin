package learning.rxjava.ch04

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.TimeUnit.SECONDS


fun main(args: Array<String>) {

    val msPeriod: Long = 300
    val secPeriod: Long = 1

    println("seconds.withLatestFrom(millis, ...)")
    val millis1 = newInterval(msPeriod, MILLISECONDS)
    val seconds1 = newInterval(secPeriod, SECONDS)
    val disposable1 = seconds1.withLatestFrom(millis1,
            BiFunction { secCount: Long, msCount: Long ->
                "{ ${elapsed(secCount, secPeriod, "s")} , ${elapsed(msCount, msPeriod, "ms")} }"
            }
    ).subscribe(::println)

    SECONDS.sleep(4)
    disposable1.dispose()

    println("--")
    println("millis.withLatestFrom(seconds, ...)")
    val millis2 = newInterval(msPeriod, MILLISECONDS)
    val seconds2 = newInterval(secPeriod, SECONDS)
    millis2.withLatestFrom(seconds2,
            BiFunction { msCount: Long, secCount: Long ->
                "{ ${elapsed(msCount, msPeriod, "ms")} , ${elapsed(secCount, secPeriod, "s")} }"
            }
    ).subscribe(::println)

    SECONDS.sleep(4)
}

private fun newInterval(period: Long, unit: TimeUnit): Observable<Long> =
        Observable.interval(period, unit)

private fun elapsed(count: Long, period: Long, unitAbbreviation: String): String =
        "${(count + 1) * period}$unitAbbreviation"