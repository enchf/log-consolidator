package utils

import java.io.File

fun logRoot() = "/Users/ernesto/temp"
fun logFolder() = File(logRoot())
fun listLogFiles() =  logFolder().listFiles().map { it!! }

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        logRoot().let(::println)
        listLogFiles().forEach(::println)
    }
}
