
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

fun winningBoardAndNumber(drawnList: List<Int>,
                          boardList: List<Board>): Pair<Int, Board> {
    return Pair(0, boardList[0])
}
