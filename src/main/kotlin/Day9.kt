
data class HeightPoint(val height: Int, val x: Int, val y: Int)
typealias HeightMap = List<List<Int>>

private fun findNeighborPoints(point: HeightPoint,
                               pointSet: Set<HeightPoint>): List<HeightPoint> {
    val upperNeighbor = pointSet.find { it.x == point.x - 1 && it.y == point.y }
    val lowerNeighbor = pointSet.find { it.x == point.x + 1 && it.y == point.y }
    val leftNeighbor = pointSet.find { it.x == point.x && it.y == point.y - 1 }
    val rightNeighbor = pointSet.find { it.x == point.x && it.y == point.y + 1 }
    return listOfNotNull(upperNeighbor, lowerNeighbor,
        leftNeighbor, rightNeighbor)
}

fun findLowPoints(heightMap: HeightMap): List<Int> {
    val pointSet = heightMap.flatMapIndexed { indexRow, rowList ->
        rowList.mapIndexed { indexCol, cellValue ->
            HeightPoint(cellValue, indexCol, indexRow)
        }
    }.toSet()
    return pointSet.map { heightPoint ->
            val neighborList = findNeighborPoints(heightPoint, pointSet)
            val heightList = neighborList.map { it.height }
            val neighborMin = heightList.minOrNull()
            if(neighborMin != null && heightPoint.height < neighborMin){
                heightPoint.height
            } else {
                Int.MAX_VALUE
            }
        }.filter { it != Int.MAX_VALUE }
}

fun findBasinSizes(heightMap: HeightMap): List<Int> {
    return listOf()
}