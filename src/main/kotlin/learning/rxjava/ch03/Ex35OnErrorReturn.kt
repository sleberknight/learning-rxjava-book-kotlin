package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    val source = Observable.just(5, 2, 4, 0, 3, 2, 8)

    // Exits early after the / by 0
    source.map { 10 / it }
            .onErrorReturnItem(-1)
            .subscribe(
                    { value -> println("Received: $value") },
                    { e -> println("Error: $e") },
                    { println("Complete") }
            )

    // Exits early after the / by 0
    source.map { 10 / it }
            .onErrorReturn { _ -> -1 }
            .subscribe(
                    { value -> println("Received: $value") },
                    { e -> println("Error: $e") },
                    { println("Complete") }
            )

    // Continues after the / by 0
    source.map { i ->
            val returnVal: Int = try {
            10 / i
        } catch (e: Exception) {
            -1
        }
        returnVal
    }.subscribe(
            { value -> println("Received: $value") },
            { e -> println("Error: $e") },
            { println("Complete") }
    )

}
