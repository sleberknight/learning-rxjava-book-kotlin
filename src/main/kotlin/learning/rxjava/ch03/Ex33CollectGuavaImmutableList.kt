package learning.rxjava.ch03

import com.google.common.collect.ImmutableList
import io.reactivex.Observable


/**
 * As with Ex32Collect.kt I could not figure out how to just use constructor and method references
 * as in the Java example where collect looks like:
 *
 * .collect(ImmutableList::builder, ImmutableList.Builder::add)
 *
 * Again, probably my beginner level of Kotlin knowledge...
 */
fun main(args: Array<String>) {

    // 1. Method reference in map
    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .collect({ ImmutableList.Builder<String>() }, { set, next -> set.add(next) })
            .map(ImmutableList.Builder<String>::build)
            .subscribe { set -> println("Result: $set") }

    // 2. Lambda in map...nicer
    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .collect({ ImmutableList.Builder<String>() }, { set, next -> set.add(next) })
            .map { it.build() }
            .subscribe { set -> println("Result: $set") }

}
