
typealias BoardRow = List<Int>
typealias Board = List<BoardRow>

fun createBoards(rawRowList: List<String>): List<Board> {
    val rawBoardList = rawRowList.chunked(6)
    return rawBoardList.map { rawBoard ->
        rawBoard.filter { it.isNotEmpty() }.map {
                rawRow ->
                    val spacedNumberList = rawRow.split(" ")
                    spacedNumberList.filter { it.isNotEmpty() }.map { it.toInt() }
        }
    }
}

private fun boardHasBingo(drawnList: List<Int>, board: Board): Boolean {
    val anyRowHasBingo = board.any { row -> drawnList.containsAll(row) }
    val columnList = (board.indices).map { column ->
        board.map { row -> row[column] }
    }
    val anyColumnHasBingo = columnList.any { drawnList.containsAll(it) }
    return anyRowHasBingo || anyColumnHasBingo
}

fun winningBoardAndNumber(drawnList: List<Int>,
                          boardList: List<Board>): Pair<Int, Board> {
    val drawCount = drawnList.size
    for(x in 5..drawCount) {
        val checkList = drawnList.subList(0, x)
        val winningBoard = boardList.find { boardHasBingo(checkList, it) }
        if(winningBoard != null){
            return Pair(checkList.last(), winningBoard)
        }
    }
    return Pair(0, boardList[0])
}

fun getUnmarkedNumbers(drawnList: List<Int>, board: Board): List<Int> {
    val boardNumberList = board.flatten()
    return boardNumberList.minus(drawnList.toSet())
}

fun scoreBoard(drawnList: List<Int>, board: Board): Int {
    val unmarkedList = getUnmarkedNumbers(drawnList, board)
    val winningNumber = drawnList.last()
    val unmarkedSum = unmarkedList.sum()
    return winningNumber * unmarkedSum
}
