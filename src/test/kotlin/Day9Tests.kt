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

    @Test
    @DisplayName("Should solve for large heightmap")
    fun should_solve_large_heightmap(){
        val path = Paths.get("src/test/kotlin/Day9Big.txt")
        val stringList = readStringListFromPath(path)
        val heightMap = stringList.map { string ->
            string.toCharArray().map {
                    char -> char.digitToInt()
            }
        }

        val lowPointList = findLowPoints(heightMap)
        val riskSum = lowPointList.sumOf { it + 1 }
        assertEquals(468,riskSum)
    }

    @Test
    @DisplayName("Should solve for small basin map")
    fun should_solve_small_basin_map(){
        val path = Paths.get("src/test/kotlin/Day9Small.txt")
        val stringList = readStringListFromPath(path)
        val heightMap = stringList.map { string ->
            string.toCharArray().map {
                    char -> char.digitToInt()
            }
        }

        val basinList = findBasinSizes(heightMap)
        println(basinList.sum())
        assertEquals(13,0)
    }
}