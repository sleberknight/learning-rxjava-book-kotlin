package ch06.subscribeon

import com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit.SECONDS

/**
 * Shows ch06.subscribeon using the newThread scheduler with an interval Observable.
 */
fun main(args: Array<String>) {

    val ticks = Observable.interval(1, SECONDS, Schedulers.newThread())

    ticks.subscribe { printTick("A", it) }
    ticks.subscribe { printTick("B", it) }
    ticks.subscribe { printTick("C", it) }

    sleepUninterruptibly(10, SECONDS)

    println("Woke up on ${currentThreadName()}...now I'm done")
}

private fun printTick(subscriber: String, tick: Long) {
    println("Subscriber $subscriber received $tick on thread ${currentThreadName()}")
}