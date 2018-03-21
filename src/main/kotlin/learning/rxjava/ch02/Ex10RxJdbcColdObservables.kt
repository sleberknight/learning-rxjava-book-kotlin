package learning.rxjava.ch02

import com.github.davidmoten.rx.jdbc.ConnectionProviderFromUrl
import com.github.davidmoten.rx.jdbc.Database
import com.google.common.io.Resources
import java.io.File


fun main(args: Array<String>) {

    val path = File(Resources.getResource("rexon_metals.db").toURI()).absolutePath
    val conn = ConnectionProviderFromUrl("jdbc:sqlite:$path").get()
    val db = Database.from(conn)

    val customerNames = db.select("select name from customer")
            .getAs(String::class.java)

    customerNames.subscribe { println(it) }

}