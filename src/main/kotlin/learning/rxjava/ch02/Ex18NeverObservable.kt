package learning.rxjava.ch02

import io.reactivex.Observable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import java.util.concurrent.TimeUnit.SECONDS


fun main(args: Array<String>) {

    Observable.never<String>()
            .subscribe(
                    Consumer(::println),
                    Consumer(Throwable::printStackTrace),
                    Action { println("Done!") }
            )

    println("Sleeping...")
    SECONDS.sleep(5)
}