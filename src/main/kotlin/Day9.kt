import kotlin.math.abs

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

private fun heightMapToPointSet(heightMap: HeightMap): Set<HeightPoint> {
    return heightMap.flatMapIndexed { indexRow, rowList ->
        rowList.mapIndexed { indexCol, cellValue ->
            HeightPoint(cellValue, indexCol, indexRow)
        }
    }.toSet()
}

fun findLowPoints(heightMap: HeightMap): List<Int> {
    val pointSet = heightMapToPointSet(heightMap)
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
    val basinList = mutableListOf<List<HeightPoint>>()
    val pointSet = heightMapToPointSet(heightMap).toMutableSet()
    while(pointSet.isNotEmpty()){
        val basin = mutableListOf<HeightPoint>()
        val point = pointSet.toList()[0]
        if(point.height != 9){
            basin.add(point)
            var hasNeighbor = true
            while(hasNeighbor) {
                val neighborList = pointSet.filter { (it.x == point.x &&
                        abs(it.y - point.y) == 1) ||
                        (it.y == point.y &&
                                abs(it.x - point.x) == 1)
                }
                if(neighborList.isEmpty()){
                    hasNeighbor = false
                } else {
                    pointSet.removeAll(neighborList.toSet())
                    basin.addAll(neighborList.filter { it.height != 9 })
                }
            }
        } else {
            pointSet.remove(point)
        }
        basinList.add(basin)
        pointSet.removeAll(basin.toSet())
    }
    return basinList.filter { it.isNotEmpty() }.map { it.size }
}