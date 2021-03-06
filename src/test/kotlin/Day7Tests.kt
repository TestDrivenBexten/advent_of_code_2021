import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.file.Paths

@DisplayName("Day 7 Tests")
class Day7Tests {
    @Test
    @DisplayName("Should solve fuel to position 10")
    fun should_solve_fuel_to_position_10() {
        val path = Paths.get("src/test/kotlin/Day7Small.txt")
        val stringList = readStringListFromPath(path)[0].split(",")
        val positionList = stringList.map { it.toInt() }
        val fuelSpent = calculateFuelToPosition(positionList, 10)
        assertEquals(71, fuelSpent)
    }

    @Test
    @DisplayName("Should solve for few crab submarines")
    fun should_solve_for_few_crab_submarines() {
        val path = Paths.get("src/test/kotlin/Day7Small.txt")
        val stringList = readStringListFromPath(path)[0].split(",")
        val positionList = stringList.map { it.toInt() }
        val fuelSpent = calculateFuel(positionList)
        assertEquals(37, fuelSpent)
    }

    @Test
    @DisplayName("Should solve for many crab submarines")
    fun should_solve_for_many_crab_submarines() {
        val path = Paths.get("src/test/kotlin/Day7Big.txt")
        val stringList = readStringListFromPath(path)[0].split(",")
        val positionList = stringList.map { it.toInt() }
        val fuelSpent = calculateFuel(positionList)
        assertEquals(345035, fuelSpent)
    }

    @Test
    @DisplayName("Should solve odd fuel to position 5")
    fun should_solve_odd_fuel_to_position_5() {
        val path = Paths.get("src/test/kotlin/Day7Small.txt")
        val stringList = readStringListFromPath(path)[0].split(",")
        val positionList = stringList.map { it.toInt() }
        val fuelSpent = calculateOddFuelToPosition(positionList, 5)
        assertEquals(168, fuelSpent)
    }

    @Test
    @DisplayName("Should solve odd fuel for many crab submarines")
    fun should_solve_odd_fuel_for_many_crab_submarines() {
        val path = Paths.get("src/test/kotlin/Day7Big.txt")
        val stringList = readStringListFromPath(path)[0].split(",")
        val positionList = stringList.map { it.toInt() }
        val fuelSpent = calculateOddFuel(positionList)
        assertEquals(97038163, fuelSpent)
    }
}