package learning.rxjava.ch03

import io.reactivex.Observable
import java.time.LocalDate


fun main(args: Array<String>) {

    Observable.just("2016-01-01", "2016-05-02", "2016-09-12", "2016-04-03")
            .map(LocalDate::parse)
            .doOnNext { println("Evaluating: $it") }
            .any { dt -> dt.monthValue >= 6 }
            .subscribe { anyAfterMay -> println("Any dates after May? $anyAfterMay") }

}