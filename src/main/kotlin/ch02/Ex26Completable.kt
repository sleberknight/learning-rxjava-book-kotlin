package ch02

import io.reactivex.Completable


fun main(args: Array<String>) {

    Completable.fromRunnable { println("42") }
            .subscribe(
                    { println("Complete") },
                    { it.printStackTrace() })

}