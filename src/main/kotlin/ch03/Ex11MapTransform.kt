package ch03

import io.reactivex.Observable
import java.time.LocalDate
import java.time.format.DateTimeFormatter


fun main(args: Array<String>) {

    val formatter = DateTimeFormatter.ofPattern("M/d/yyyy")

    val source = Observable.just("1/3/2016", "5/9/2016", "10/12/2016")
            .map { LocalDate.parse(it, formatter) }

    source.subscribe { println("Date: $it") }

    source.map { it.dayOfWeek }
            .subscribe { println("Day of week: $it") }

}