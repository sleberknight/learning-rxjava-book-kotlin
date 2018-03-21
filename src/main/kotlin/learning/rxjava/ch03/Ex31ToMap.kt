package learning.rxjava.ch03

import io.reactivex.Observable
import java.util.concurrent.ConcurrentHashMap


fun main(args: Array<String>) {

    val printer: (Any) -> Unit = { println("${it.javaClass.name}: $it") }


    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .toMap { it[0] }
            .subscribe(printer)


    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .toMap({ str -> str[0] }, String::length)
            .subscribe(printer)


    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .toMap(
                    { str -> str[0] },
                    String::length,
                    { ConcurrentHashMap() }
            )
            .subscribe(printer)


    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .toMap { it.length }
            .subscribe(printer)


    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .toMultimap { it.length }
            .subscribe(printer)

}