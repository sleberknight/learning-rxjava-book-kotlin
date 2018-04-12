package learning.rxjava.ch04

import io.reactivex.Observable
import io.reactivex.functions.BiFunction


fun main(args: Array<String>) {

    val source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    val source2 = Observable.range(1, 6)

    val zipper = BiFunction { str: String, num: Int -> "$str-$num" }

    Observable.zip(source1, source2, zipper)
            .subscribe(
                    { println(it) },
                    { it.printStackTrace() },
                    { println("-- Done Observable.zip! --") })

    source1.zipWith(source2, zipper).subscribe(::println)

}