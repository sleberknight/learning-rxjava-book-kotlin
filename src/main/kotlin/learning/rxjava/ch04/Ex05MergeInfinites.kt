package learning.rxjava.ch04

import io.reactivex.Observable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.TimeUnit.SECONDS


val LOGGER: Logger = LoggerFactory.getLogger("learning.rxjava.ch04.Ex05MergingInfinites")


fun main(args: Array<String>) {

    val source1 = Observable.interval(1, SECONDS)
            .map { it + 1 }
            .doOnNext { logCurrentThread("Source 1") }
            .map { "Source 1: $it seconds" }

    val source2 = Observable.interval(300, MILLISECONDS)
            .map { (it + 1) * 300 }
            .doOnNext { logCurrentThread("Source 2") }
            .map { "Source 2: $it milliseconds" }

    Observable.merge(source1, source2).subscribe(LOGGER::info)

    SECONDS.sleep(3)
}

private fun logCurrentThread(source: String): Unit = LOGGER.debug("  ($source thread: ${currentThread()})")

private fun currentThread(): String = Thread.currentThread().name