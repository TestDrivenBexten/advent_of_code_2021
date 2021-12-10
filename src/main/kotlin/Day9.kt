
typealias HeightMap = List<List<Int>>

fun findLowPoints(heightMap: HeightMap): List<Int> {
    return heightMap.mapIndexed { indexRow, rowList ->
        rowList.mapIndexed { indexCol, cellValue ->
            val upperNeighbor = heightMap.getOrNull(indexRow - 1)?.getOrNull(indexCol)
            val lowerNeighbor = heightMap.getOrNull(indexRow + 1)?.getOrNull(indexCol)
            val leftNeighbor = heightMap.getOrNull(indexRow)?.getOrNull(indexCol - 1)
            val rightNeighbor = heightMap.getOrNull(indexRow)?.getOrNull(indexCol + 1)
            val neighborList = listOfNotNull(upperNeighbor, lowerNeighbor,
                                        leftNeighbor, rightNeighbor)
            val neighborMin = neighborList.minOrNull()
            println(neighborList)
            println(neighborMin)
            if(neighborMin != null && cellValue < neighborMin){
                cellValue
            } else {
                Int.MAX_VALUE
            }
        }
    }.flatten().filter { it != Int.MAX_VALUE }
}