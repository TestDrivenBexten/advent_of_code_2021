import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.file.Paths
import kotlin.test.assertEquals

@DisplayName("Day 3 Tests")
class Day3Tests {

    private fun parseBinary(rawString: String): List<Int> {
        return rawString.map { it.digitToInt() }
    }

    @Test
    @DisplayName("Should determine power consumption from 12 5-bit numbers")
    fun should_solve_for_12_5_bit_numbers(){
        val path = Paths.get("src/test/kotlin/Day3Small.txt")
        val stringList = readStringListFromPath(path)
        val binaryList = stringList.map { parseBinary(it) }
        val powerConsumption = calculatePowerConsumption(binaryList)
        assertEquals(198, powerConsumption)
    }

    @Test
    @DisplayName("Should determine power consumption from 1000 12-bit numbers")
    fun should_solve_for_1000_12_bit_numbers(){
        val path = Paths.get("src/test/kotlin/Day3Big.txt")
        val stringList = readStringListFromPath(path)
        val binaryList = stringList.map { parseBinary(it) }
        val powerConsumption = calculatePowerConsumption(binaryList)
        assertEquals(3895776, powerConsumption)
    }

    @Test
    @DisplayName("Should determine life support rating from 12 5-bit numbers")
    fun should_find_life_support_for_12_5_bit_numbers(){
        val path = Paths.get("src/test/kotlin/Day3Small.txt")
        val stringList = readStringListFromPath(path)
        val binaryList = stringList.map { parseBinary(it) }
        val lifeSupportRating = calculateLifeSupportRating(binaryList)
        assertEquals(230, lifeSupportRating)
    }
}