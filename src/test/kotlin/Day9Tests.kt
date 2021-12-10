import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.file.Paths
import kotlin.test.assertEquals

@DisplayName("Day 9 Tests")
class Day9Tests {

    @Test
    @DisplayName("Should solve for small heightmap")
    fun should_solve_small_heightmap(){
        val path = Paths.get("src/test/kotlin/Day9Small.txt")
        val stringList = readStringListFromPath(path)
        val heightMap = stringList.map { string ->
            string.toCharArray().map {
                char -> char.digitToInt()
            }
        }

        val lowPointList = findLowPoints(heightMap)
        val riskSum = lowPointList.sumOf { it + 1 }
        assertEquals(15,riskSum)
    }
}