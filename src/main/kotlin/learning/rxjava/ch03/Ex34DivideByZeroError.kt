package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just(5, 2, 4, 0, 3, 2, 8)
            .map { 10 / it }
            .subscribe(
                    { value -> println("Received: $value") },
                    { e -> println("Error: $e") }
            )
    
}
