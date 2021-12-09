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
    @DisplayName("Should find output of single input")
    fun should_find_output_of_single_input() {
        val inputList = listOf("be","cfbegad","cbdgef","fgaecd","cgeb","fdcge",
                                "agebfd","fecdb","fabcd","edb")
        val outputList = listOf("fdgacbe","cefdb","cefbgd","gcbe")
        val inputOutput = InputOutput(inputList, outputList)

        val outputSum = decipherDigits(listOf(inputOutput)).sum()
        assertEquals(8394, outputSum)
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

        val outputSum = decipherDigits(inputOutList).sum()
        assertEquals(61229, outputSum)
    }

    @Test
    @DisplayName("Should find sum of many outputs")
    fun should_find_sum_of_many_outputs() {
        val path = Paths.get("src/test/kotlin/Day8Big.txt")
        val stringList = readStringListFromPath(path)
        val inputList = stringList.map { it.split("|")[0] }
        val outputList = stringList.map { it.split("|")[1] }
        val combinedList = inputList.zip(outputList)
        val inputOutList = combinedList.map { (input, output) ->
            val splitInputList = input.split(" ").dropLast(1)
            val splitOutputList = output.split(" ").drop(1)
            InputOutput(splitInputList, splitOutputList)
        }

        val outputSum = decipherDigits(inputOutList).sum()
        assertEquals(1084606, outputSum)
    }
}