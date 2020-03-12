package utils

import java.time.LocalDateTime

// Format: 2016-12-20T19:00:45Z
fun String.parseLogDateFormat() = LocalDateTime.parse(dropLast(1))!!
fun LocalDateTime.printFancy() = String
        .format("%s %d of %d at time: %02d : %02d : %02d",
                month.name,
                dayOfMonth,
                year,
                hour,
                minute,
                second)
        .let(::println)

fun lineDate(line: String) = line.split(",").first().parseLogDateFormat()

object TestLogFunctions {
    @JvmStatic
    fun main(args: Array<String>) {
        "2016-12-20T19:00:45Z".parseLogDateFormat().printFancy()
        "2021-05-20T01:00:25Z, Process started in server A".let(::lineDate).printFancy()
    }
}