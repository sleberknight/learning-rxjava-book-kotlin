package ch02

import io.reactivex.Observable


/**
 * Does NOT use fromCallable and exception escapes.
 */
fun main(args: Array<String>) {

    @Suppress("DIVISION_BY_ZERO")
    Observable.just(1 / 0)
            .subscribe(
                    { println("Received: $it") },
                    { println("Error caught: ${it.message}") },  // will NOT be printed!
                    { println("Done (this will never be printed)") })

}