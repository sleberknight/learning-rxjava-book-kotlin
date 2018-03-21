package learning.rxjava.ch02

import io.reactivex.Observable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer


fun main(args: Array<String>) {

    Observable.empty<String>()
            .subscribe(
                    Consumer(::println),
                    Consumer(Throwable::printStackTrace),
                    Action { println("Done!") })

}