package ch06.subscribeon

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Shows ch06.subscribeon using fromCallable reading from a URL as JSON.
 */
fun main(args: Array<String>) {

    val mapper = jacksonObjectMapper()
    val prettyPrinter = mapper.writerWithDefaultPrettyPrinter()

    val url = "https://api.github.com/users/sleberknight/repos"
    println("Reading from URL: $url")

    Observable.fromCallable { readTextFromUrl(url) }
        .subscribeOn(Schedulers.io())
        .map { simulateNetworkDelay(it) }
        .subscribe { prettyPrint(it, mapper, prettyPrinter) }

    println("Moving on...taking a nap on thread ${currentThreadName()}")

    sleepUninterruptibly(6, TimeUnit.SECONDS)

    println("Woke up on thread ${currentThreadName()}...now I'm done")
}
