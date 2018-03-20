package ch02

import io.reactivex.Single
import io.reactivex.functions.Consumer


fun main(args: Array<String>) {

    Single.just("this once...")
            .map(String::length)
            .subscribe(
                    Consumer(::println),
                    Consumer(Throwable::printStackTrace)
            )
}