package learning.rxjava.ch03

import io.reactivex.Observable


fun main(args: Array<String>) {

    val menu = Observable.just("Coffee", "Tea", "Espresso", "Latte")

    val title = "HIGH-LIFE COFFEE MENU"
    val underline = "-".times(title.length)
    menu.startWithArray(title, underline).subscribe(::println)

}

// Just to play with extension functions.
// Normally would just use the built-in repeat function.
// See: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/repeat.html
private fun String.times(count: Int): String {
    val sb = StringBuilder(length * count)
    for (i in 1..count) {
        sb.append(this)
    }
    return sb.toString()
}