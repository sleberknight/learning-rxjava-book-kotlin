package learning.rxjava.ch02

import io.reactivex.Observable


fun main(args: Array<String>) {

    val source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    source.firstElement()
            .subscribe(
                    { println("Received $it") },
                    { it.printStackTrace() },
                    { println("Done") }
            )

}