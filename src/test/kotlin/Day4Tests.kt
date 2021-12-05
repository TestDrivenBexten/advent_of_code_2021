import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.file.Paths
import kotlin.test.assertEquals

@DisplayName("Day 4 Tests")
class Day4Tests {
    @Test
    @DisplayName("Should solve bingo for small boards")
    fun should_solve_for_small_boards(){
        val path = Paths.get("src/test/kotlin/Day4Small.txt")
        val stringList = readStringListFromPath(path)
        val drawnNumberList = stringList[0].split(",").map { it.toInt() }
        val boardList = createBoards(stringList.subList(2,stringList.size))
        val (winningNumber, board) = winningBoardAndNumber(drawnNumberList, boardList)
        println(winningNumber)
        println(board)

        assertEquals(0,1)
    }
}