package ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
            .sorted(Comparator.reverseOrder())
            .subscribe(::println)

}