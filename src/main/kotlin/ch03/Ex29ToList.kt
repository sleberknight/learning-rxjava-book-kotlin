package ch03

import io.reactivex.Observable
import java.util.concurrent.CopyOnWriteArrayList


fun main(args: Array<String>) {

    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .toList()
            .subscribe { theList -> println("Received: $theList") }


    Observable.range(1, 1000)
            .toList(1000)
            .subscribe { theList -> println("Received list of size ${theList.size}") }


    Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .toList { CopyOnWriteArrayList<String>() }
            .subscribe { theList -> println("Received ${theList.javaClass.name}: $theList") }

}