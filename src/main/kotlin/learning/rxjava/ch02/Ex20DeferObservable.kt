package learning.rxjava.ch02

import io.reactivex.Observable
import java.util.concurrent.TimeUnit


fun main(args: Array<String>) {

    println("Using range() Observable without defer() - change to count will have NO effect")
    DoesNotDefer().run()

    TimeUnit.SECONDS.sleep(1)

    println("Use range() Observable with defer() - change to count WILL have an effect")
    Deferring().run()

}

class DoesNotDefer(private val start: Int = 1, var count: Int = 5) {

    fun run() {
        val source = Observable.range(start, count)

        source.subscribe { println("Observer 1: $it") }

        count = 10

        source.subscribe { println("Observer 2: $it") }
    }

}

class Deferring(private val start: Int = 1, var count: Int = 5) {

    fun run() {
        val source = Observable.defer { Observable.range(start, count) }

        source.subscribe { println("Observer 1: $it") }

        count = 10

        source.subscribe { println("Observer 2: $it") }
    }

}