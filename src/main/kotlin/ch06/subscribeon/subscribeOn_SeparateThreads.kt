package ch06.subscribeon

import com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit.SECONDS

/**
 * Showing ch06.subscribeon the computation thread.
 */
fun main(args: Array<String>) {

    val lengths = Observable.just("alpha", "beta", "gamma", "delta", "epsilon")
        .subscribeOn(Schedulers.computation())
        .map { intenseCalculation(it) }
        .map { it.length }

    lengths.subscribe { println("Subscriber 1 received $it on thread ${currentThreadName()}") }

    lengths.subscribe { println("Subscriber 2 received $it on thread ${currentThreadName()}") }

    sleepUninterruptibly(10, SECONDS)

}
