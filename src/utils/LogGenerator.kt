package utils

import java.io.File
import java.time.LocalDateTime
import kotlin.random.Random

fun logGenerator(file: File, blocks: Int = 100, blockSize: Int = 50, initialDate: LocalDateTime = LocalDateTime.now()) {
    var currentDate = initialDate

    repeat(blocks) {
        val buffer = StringBuilder()

        repeat(blockSize) {
            buffer.append("${ currentDate.toLogFormat() }, Another entry in server.\n")
            currentDate = currentDate.plusSeconds(Random.nextLong(1, 6))
        }

        println("Writting buffer to file")
        file.appendText(buffer.toString())
    }
}

object GenerateLog {
    @JvmStatic
    fun main(args: Array<String>) =
            logGenerator(
                    fileInLogRoot("abc"),
                    7,
                    7,
                    "2020-03-12T11:27:46Z".parseLogDateFormat())
}
