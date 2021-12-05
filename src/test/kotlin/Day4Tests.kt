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

        val drawnList = drawnNumberList.takeWhile { it != winningNumber }.plus(winningNumber)
        val score = scoreBoard(drawnList, board)
        assertEquals(4512,score)
    }

    @Test
    @DisplayName("Should solve bingo for multiple boards")
    fun should_solve_for_multiple_boards(){
        val path = Paths.get("src/test/kotlin/Day4Big.txt")
        val stringList = readStringListFromPath(path)
        val drawnNumberList = stringList[0].split(",").map { it.toInt() }
        val boardList = createBoards(stringList.subList(2,stringList.size))
        val (winningNumber, board) = winningBoardAndNumber(drawnNumberList, boardList)

        val drawnList = drawnNumberList.takeWhile { it != winningNumber }.plus(winningNumber)
        val score = scoreBoard(drawnList, board)
        assertEquals(65325,score)
    }

    @Test
    @DisplayName("Should lose bingo for small boards")
    fun should_lose_for_small_boards(){
        val path = Paths.get("src/test/kotlin/Day4Small.txt")
        val stringList = readStringListFromPath(path)
        val drawnNumberList = stringList[0].split(",").map { it.toInt() }
        val boardList = createBoards(stringList.subList(2,stringList.size))
        val (number, board) = losingBoardAndNumber(drawnNumberList, boardList)

        val nextNumber = drawnNumberList.dropWhile { it != number }[1]
        val drawnList = drawnNumberList.takeWhile { it != nextNumber }.plus(nextNumber)
        val unmarkedSum = getUnmarkedNumbers(drawnList, board).sum()
        val score = nextNumber * unmarkedSum
        assertEquals(1924,score)
    }

    @Test
    @DisplayName("Should lose bingo for multiple boards")
    fun should_lose_for_multiple_boards(){
        val path = Paths.get("src/test/kotlin/Day4Big.txt")
        val stringList = readStringListFromPath(path)
        val drawnNumberList = stringList[0].split(",").map { it.toInt() }
        val boardList = createBoards(stringList.subList(2,stringList.size))
        val (number, board) = losingBoardAndNumber(drawnNumberList, boardList)

        val nextNumber = drawnNumberList.dropWhile { it != number }[1]
        val drawnList = drawnNumberList.takeWhile { it != nextNumber }.plus(nextNumber)
        val unmarkedSum = getUnmarkedNumbers(drawnList, board).sum()
        println(scoreBoard(drawnList, board))
        println(drawnList)
        println(board)
        println(nextNumber)
        val score = nextNumber * unmarkedSum
        assertEquals(1924,score)
    }
}