import utils.extractLogDate
import java.util.*

typealias Tuple = Pair<String, String>
val TUPLE_COMPARATOR = compareBy<Tuple> { it.second.extractLogDate() }

fun main() =
        utils.listLogFiles()
             .groupBy({ it.nameWithoutExtension }, { Scanner(it) })
             .mapValues { (_, scanners) -> scanners.first() }
             .let { files ->
                 val heap = PriorityQueue<Tuple>(files.size, TUPLE_COMPARATOR)

                 files.forEach { (filename, scanner) -> heap.add(Tuple(filename, scanner.nextLine()!!)) }

                 while (heap.isNotEmpty()) {
                     heap.poll().also {
                         println(it.second)

                         files[it.first]!!.let { source ->
                             if (source.hasNextLine()) {
                                 heap.add(Tuple(it.first, source.nextLine()))
                             }
                         }
                     }
                 }
             }
