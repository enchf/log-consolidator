package utils

import java.time.LocalDateTime
import kotlin.random.Random

fun logGenerator(serverName: String, blocks: Int = 100, blockSize: Int = 50, initialDate: LocalDateTime = LocalDateTime.now()) {
    var currentDate = initialDate
    val file = fileInLogRoot(serverName)

    repeat(blocks) {
        val buffer = StringBuilder()

        repeat(blockSize) {
            buffer.append("${ currentDate.toLogFormat() }, Another entry in server $serverName.\n")
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
                    "h342fd",
                    700,
                    1000,
                    "2020-03-12T11:27:46Z".parseLogDateFormat())
}
