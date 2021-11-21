import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.file.Paths
import kotlin.test.assertEquals

@DisplayName("Puzzle Input Tests")
class ReadPuzzleInputTests {
    @Test
    @DisplayName("Should read 'Hello World' from file")
    fun should_read_hello_world_for_string_list(){
        val path = Paths.get("src/test/kotlin/string.txt")
        val stringList = readStringListFromPath(path)
        assertEquals(listOf("Hello","World"), stringList)
    }

    @Test
    @DisplayName("Should read integers from file")
    fun should_read_integer_list(){
        val path = Paths.get("src/test/kotlin/integer.txt")
        val intList = readIntListFromPath(path)
        assertEquals(listOf(5,17,2359,-34,0), intList)
    }

    @Test
    @DisplayName("Should read longs from file")
    fun should_read_long_list(){
        val path = Paths.get("src/test/kotlin/long.txt")
        val longList = readLongListFromPath(path)
        assertEquals(listOf(92147483647), longList)
    }
}