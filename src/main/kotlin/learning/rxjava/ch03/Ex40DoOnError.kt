package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just(5, 2, 4, 0, 3, 2, 8)
            .doOnError { e -> println("Source failed: ${e.message}") }
            .map { 10 / it }
            .doOnError { e -> println("Division failed: ${e.message}") }
            .subscribe(
                    { println("Received: $it") },
                    { e -> println("Error: $e") })

}