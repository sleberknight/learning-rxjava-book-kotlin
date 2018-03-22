package learning.rxjava.ch03

import io.reactivex.Observable


/**
 * The "resume next" part confused me initially...it doesn't resume with the next emission
 * from the original Observable, but rather resumes with the supplied new Observable. I
 * guess that is fine once you understand it, but the name confused me at first.
 */
fun main(args: Array<String>) {

    val source = Observable.just(5, 2, 4, 0, 3, 2, 8)

    // Resume with an Observable that repeats -1 three times
    source.map { 10 / it }
            .onErrorResumeNext { _: Throwable -> Observable.just(-1).repeat(3) }
            .subscribe(
                    { value -> println("Received: $value") },
                    { e -> println("Error: $e") },
                    { println("#1 Complete") }
            )

    // The Observable.empty() quietly stops emissions after an error occurs...
    source.map { 10 / it }
            .onErrorResumeNext(Observable.empty())
            .subscribe(
                    { value -> println("Received: $value") },
                    { e -> println("Error: $e") },
                    { println("#2 Complete") }
            )
    
}