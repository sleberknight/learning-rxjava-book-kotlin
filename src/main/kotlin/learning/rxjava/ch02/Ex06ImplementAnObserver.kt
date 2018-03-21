package learning.rxjava.ch02

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


fun main(args: Array<String>) {

    val myObserver = object : Observer<Int> {
        override fun onComplete() {
            println("Done")
        }

        override fun onSubscribe(d: Disposable) {
            // no-op
        }

        override fun onNext(value: Int) {
            println("Received: $value")
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
        }
    }

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .map { it.length }
            .filter { it >= 5 }
            .subscribe(myObserver)

}