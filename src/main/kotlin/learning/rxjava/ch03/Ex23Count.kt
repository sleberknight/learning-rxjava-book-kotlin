package learning.rxjava.ch03

import io.reactivex.Observable
import io.reactivex.functions.Consumer


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .count()
            .subscribe(Consumer { println("Count: $it") })

}