package learning.rxjava.ch01

import io.reactivex.Observable
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit.SECONDS


fun main(args: Array<String>) {

    val seconds = Observable.interval(1, SECONDS)

    seconds.subscribe { println(it) }

    sleep(5000)

}
