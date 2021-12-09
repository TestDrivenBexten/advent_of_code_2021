import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.file.Paths
import kotlin.test.assertEquals

@DisplayName("Day 8 Tests")
class Day8Tests {

    @Test
    @DisplayName("Should count unique small outputs")
    fun should_count_unique_small_outputs() {
        val path = Paths.get("src/test/kotlin/Day8Small.txt")
        val stringList = readStringListFromPath(path)
        val outputList = stringList.filterIndexed { index, _ -> index % 2 == 1 }
        val count = countUniqueOutputList(outputList)
        assertEquals(26, count)
    }

    @Test
    @DisplayName("Should count unique large outputs")
    fun should_count_unique_large_outputs() {
        val path = Paths.get("src/test/kotlin/Day8Big.txt")
        val stringList = readStringListFromPath(path)
        val outputList = stringList.map { it.split("|")[1] }
        val count = countUniqueOutputList(outputList)
        assertEquals(539, count)
    }

    @Test
    @DisplayName("Should find sum of small outputs")
    fun should_find_sum_of_small_outputs() {
        val path = Paths.get("src/test/kotlin/Day8Small.txt")
        val stringList = readStringListFromPath(path)
        val inputList = stringList.filterIndexed { index, _ -> index % 2 == 0 }
        val outputList = stringList.filterIndexed { index, _ -> index % 2 == 1 }
        val combinedList = inputList.zip(outputList)
        val inputOutList = combinedList.map { (input, output) ->
            val splitInputList = input.split(" ").dropLast(1)
            val splitOutputList = output.split(" ")
            InputOutput(splitInputList, splitOutputList)
        }
        println(inputOutList)

        val outputSum = decipherDigits(inputOutList).sum()
        assertEquals(61229, outputSum)
    }
}