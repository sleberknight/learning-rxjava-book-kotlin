package ch03

import io.reactivex.Observable
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.TimeUnit.SECONDS


fun main(args: Array<String>) {

    Observable.interval(300, MILLISECONDS)
            .take(2, SECONDS)
            .subscribe { println("Received: $it") }

    SECONDS.sleep(5)
}