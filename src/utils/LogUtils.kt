package utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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

fun LocalDateTime.toLogFormat() = format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"))!!
fun String.extractLogDate() = split(",").first().parseLogDateFormat()

object TestLogUtils {
    @JvmStatic
    fun main(args: Array<String>) {
        "2016-12-20T19:00:45Z".parseLogDateFormat().printFancy()
        "2021-05-20T01:00:25Z, Process started in server A".extractLogDate().printFancy()
        LocalDateTime.now().toLogFormat().let(::println)
    }
}