package ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .sorted { s1, s2 -> s1.length.compareTo(s2.length) }
            .subscribe(::println)

}
