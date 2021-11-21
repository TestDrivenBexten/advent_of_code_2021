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
        val stringList = readStringListFromFile(path)
        assertEquals(listOf("Hello","World"), stringList)
    }

}