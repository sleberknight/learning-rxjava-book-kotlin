package learning.rxjava.ch04

import io.reactivex.Observable


fun main(args: Array<String>) {

    val source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    val byLengths = source.groupBy(String::length)

    println("Grouped by lengths:")
    byLengths.flatMapSingle { group -> group.toList() }.subscribe(::println)

    println()
    println("Grouped by lengths with format length: <group>:")
    byLengths.flatMapSingle { group ->
        group.reduce("") { s1, s2 -> if (s1 == "") s2 else "$s1, $s2" }
                .map { s -> "${group.key}: $s" }
    }.subscribe(::println)
}
