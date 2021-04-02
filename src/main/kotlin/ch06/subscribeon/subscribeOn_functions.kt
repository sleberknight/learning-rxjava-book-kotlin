package ch06.subscribeon

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import com.fasterxml.jackson.module.kotlin.readValue
import com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly
import java.net.URL
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit


fun prettyPrint(json: String, mapper: ObjectMapper, prettyPrinter: ObjectWriter) {
    val map = mapper.readValue<List<Map<String, Any>>>(json)
    val prettyJson = prettyPrinter.writeValueAsString(map)
    println("Received response on thread ${currentThreadName()}:\n$prettyJson")
}

fun <T> simulateNetworkDelay(value: T): T {
    println("Simulating network delay...")
    val randomSeconds = ThreadLocalRandom.current().nextLong(3)
    sleepUninterruptibly(randomSeconds, TimeUnit.SECONDS)
    return value
}

fun readTextFromUrl(url: String): String {
    return URL(url).readText()
}

fun <T> intenseCalculation(value: T): T {
    val randomMillis = ThreadLocalRandom.current().nextLong(3000)
    println("  Calculation on $value on thread ${Thread.currentThread().name} will take: $randomMillis millis")
    sleepUninterruptibly(randomMillis, TimeUnit.MILLISECONDS)
    return value
}

fun currentThreadName(): String = Thread.currentThread().name