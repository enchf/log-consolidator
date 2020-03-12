package utils

import java.io.File

fun logRoot() = "/Users/ernesto/temp"
fun logFolder() = File(logRoot())
fun listLogFiles() =  logFolder().listFiles().map { it!! }
fun fileInLogRoot(suffix: String) = File("${ logRoot() }/server-$suffix.log")

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        logRoot().let(::println)
        listLogFiles().forEach(::println)
        fileInLogRoot("test").let { println(it.absolutePath) }
    }
}
