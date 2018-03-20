package ch02

import io.reactivex.Observable


/**
 * Uses fromCallable and exception is handled by the 'onError' handler (it does not escape)
 */
fun main(args: Array<String>) {

    @Suppress("DIVISION_BY_ZERO")
    Observable.fromCallable { 1 / 0 }
            .subscribe(
                    { println("Received: $it") },
                    { println("Error caught: ${it.message}") },  // will be printed
                    { println("Done (this will never be printed)") })

}