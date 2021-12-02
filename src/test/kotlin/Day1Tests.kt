import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.file.Paths

@DisplayName("Day 1 Tests")
class Day1Tests {

    @Test
    @DisplayName("Should have 7 measurements")
    fun should_have_seven_greater_measurements() {
        val path = Paths.get("src/test/kotlin/Day1Small.txt")
        val intList = readIntListFromPath(path)
        val greaterCount = countGreaterMeasurements(intList)
        assertEquals(7, greaterCount)
    }

    @Test
    @DisplayName("Should count correct number of measurements")
    fun should_have_correct_count_measurements() {
        val path = Paths.get("src/test/kotlin/Day1Big.txt")
        val intList = readIntListFromPath(path)
        val greaterCount = countGreaterMeasurements(intList)
        assertEquals(1559, greaterCount)
    }

    @Test
    @DisplayName("Should have 5 sums")
    fun should_have_five_greater_sums() {
        val path = Paths.get("src/test/kotlin/Day1Small.txt")
        val intList = readIntListFromPath(path)
        val greaterCount = countGreaterWindows(intList)
        assertEquals(5, greaterCount)
    }

    @Test
    @DisplayName("Should count correct number of sums")
    fun should_have_correct_count_sums() {
        val path = Paths.get("src/test/kotlin/Day1Big.txt")
        val intList = readIntListFromPath(path)
        val greaterCount = countGreaterWindows(intList)
        assertEquals(1600, greaterCount)
    }
}