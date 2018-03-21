package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .filter { it.startsWith("Z") }
            .switchIfEmpty(Observable.just("Zeta", "Eta", "Theta"))
            .subscribe(
                    { println("Received: $it") },
                    { it.printStackTrace() }
            )

}