package ch02

import com.google.common.util.concurrent.Futures
import io.reactivex.Observable


fun main(args: Array<String>) {

    val future = Futures.immediateFuture("The answer is 42")

    Observable.fromFuture(future)
            .map(String::length)
            .subscribe(::println)
}