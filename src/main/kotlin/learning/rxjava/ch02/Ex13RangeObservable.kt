package learning.rxjava.ch02

import io.reactivex.Observable


fun main(args: Array<String>) {

    println("Range starting at 1")
    Observable.range(1, 10).subscribe { println("Received: $it") }

    println("Range starting at 5")
    Observable.range(5, 10).subscribe { println("Received: $it") }
}