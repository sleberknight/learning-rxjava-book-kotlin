package learning.rxjava.ch03

import io.reactivex.Observable
import io.reactivex.functions.Consumer


fun main(args: Array<String>) {

    Observable.just(5, 3, 7, 10, 2, 14)
            .reduce("") { total: String, next: Int ->
                when {
                    total.isBlank() -> next.toString()
                    else -> "$total, $next"
                }
            }
            .subscribe(Consumer { println("CSV: $it") })

}