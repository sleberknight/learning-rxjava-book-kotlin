package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    val source = Observable.just(5, 2, 4, 0, 3, 2, 8)

    // Limit to 5 retries
    source.map { 10 / it }
            .retry(5)
            .subscribe(
                    { value -> println("Received: $value") },
                    { e -> println("Error: $e") },
                    { println("#1 Complete") }
            )

}