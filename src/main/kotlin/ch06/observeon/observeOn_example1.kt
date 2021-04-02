package ch06.observeon

import ch06.subscribeon.currentThreadName
import com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit.SECONDS

/**
 * Shows how to use observeOn in a basic fashion.
 */
fun main(args: Array<String>) {

    Observable.just("WHISKEY/27653/TANGO", "6555/BRAVO", "232352/5675675/FOXTROT")
        .subscribeOn(Schedulers.io())
        .flatMap { Observable.fromIterable(it.split("/")) }
        .observeOn(Schedulers.computation())
        .filter { it -> it.matches(Regex("[0-9]+")) }
        .map { it.toInt() }
        .reduce { total, next -> total + next }
        .subscribe { println("Received $it on thread ${currentThreadName()}") }

    sleepUninterruptibly(1, SECONDS)
}
