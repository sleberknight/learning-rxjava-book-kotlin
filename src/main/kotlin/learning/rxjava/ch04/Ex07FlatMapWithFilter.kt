package learning.rxjava.ch04

import io.reactivex.Observable


fun main(args: Array<String>) {

    Observable.just("521934/2342/FOXTROT", "21962/12112/78886/TANGO", "283242/4542/WHISKEY/2348562")
            .flatMap { Observable.fromIterable(it.split("/")) }
            .filter { it.matches(Regex("[0-9]+")) }
            .map(String::toInt)
            .subscribe(::println)

}