import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.file.Paths

@DisplayName("Day 5 Tests")
class Day5Tests {
    private val lineRegex = Regex("(\\d+),(\\d+) -> (\\d+),(\\d+)")
    private fun parseLine(rawLine: String): Line {
        val matchResult = lineRegex.find(rawLine)
        val pointPositions = matchResult?.groupValues?.subList(1,5)?.map { it.toInt() }
        val point1 = Point(pointPositions!![0],pointPositions[1])
        val point2 = Point(pointPositions[2],pointPositions[3])
        return Line(point1, point2)
    }

    @Test
    @DisplayName("Should solve for few lines")
    fun should_solve_for_few_lines() {
        val path = Paths.get("src/test/kotlin/Day5Small.txt")
        val stringList = readStringListFromPath(path)
        val lineList = stringList.map { parseLine(it) }
        println(lineList)
    }
}