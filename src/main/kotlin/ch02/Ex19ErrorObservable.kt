package ch02

import io.reactivex.Observable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import java.util.concurrent.atomic.AtomicInteger


fun main(args: Array<String>) {

    Observable.error<String>(Exception("oops 0"))
            .subscribe(
                    Consumer(::println),
                    Consumer(Throwable::printStackTrace),
                    Action { println("Done 1") })

    val counter = AtomicInteger()

    val source = Observable.error<String> {
        counter.incrementAndGet()
        Exception("oops ${counter.get()}")
    }

    source.subscribe(
            Consumer(::println),
            Consumer(Throwable::printStackTrace),
            Action { println("Done 2") })

    source.subscribe(
            Consumer(::println),
            Consumer(Throwable::printStackTrace),
            Action { println("Done 3") })

    println("Final oops count is ${counter.get()}")
}