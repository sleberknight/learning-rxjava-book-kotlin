package learning.rxjava.ch03

import io.reactivex.Observable


/**
 * In Java the collect looks like:
 *
 * .collect(HashSet::new, HashSet::add)
 *
 * But in Kotlin I cannot make this work as nicely which is probably due to my
 * beginner level of Kotlin knowledge...see two attempts below.
 */
fun main(args: Array<String>) {

    // 1. Using explicit lambdas for initialValueSuppler and collector
    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .collect({ HashSet<String>() }, { set, next -> set.add(next) })
            .subscribe { set -> println("Result: $set") }

    // 2. Using constructor reference and explicit lambda (needed explicit type on set)
    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .collect(::HashSet, { set: MutableSet<String>, next -> set.add(next) })
            .subscribe { set -> println("Result: $set") }
}