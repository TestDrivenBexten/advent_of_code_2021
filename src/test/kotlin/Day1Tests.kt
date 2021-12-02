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
}