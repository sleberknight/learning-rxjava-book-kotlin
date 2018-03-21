package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    val menu = Observable.just("Coffee", "Tea", "Espresso", "Latte")

    menu.startWith("HIGH-LIFE COFFEE MENU").subscribe(::println)

}

