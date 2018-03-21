package learning.rxjava.ch02

import io.reactivex.Maybe


fun main(args: Array<String>) {

    val hasValue = Maybe.just(100)

    hasValue.subscribe(
            { println("Observer 1 received: $it") },
            { it.printStackTrace() },
            { println("Observer 1 done") }
    )

    val empty = Maybe.empty<Int>()

    empty.subscribe(
            { println("Observer 2 received: $it") },
            { it.printStackTrace() },
            { println("Observer 2 done") }
    )

}