package ch02

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit.SECONDS


/**
 * The book example has a while loop that creates an infinite loop, so removed that here
 * and just have the isDisposed check on the emitter.
 */
fun main(args: Array<String>) {

    val source = Observable.create<Int> { emitter ->
        try {
            for (value in 0..1_000_000) {
                if (emitter.isDisposed) {
                    return@create
                }
                emitter.onNext(value)
            }

            emitter.onComplete()
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }

    val disposable = source.subscribeOn(Schedulers.computation())
            .doOnNext { println("\tThread: ${Thread.currentThread().name}") }
            .subscribe(
                    { println("Received: $it") },
                    { it.printStackTrace() },
                    { println("Done (you will never see this)") }
            )

    SECONDS.sleep(5)

    println("Disposing...")
    disposable.dispose()

    SECONDS.sleep(3)

}