import kotlin.math.max
import kotlin.math.min

data class Point(val x: Int, val y: Int)
data class Line(val point1: Point, val point2: Point)
typealias VentMap = Map<Point, Int>

private fun buildPointList(line: Line): List<Point> {
    val (point1, point2) = line
    return if(point1.x == point2.x) {
        val y1 = point1.y
        val y2 = point2.y
        val min = min(y1, y2)
        val max = max(y1, y2)
        (min..max).map { Point(point1.x, it) }
    } else if(point1.y == point2.y) {
        val x1 = point1.x
        val x2 = point2.x
        val min = min(x1, x2)
        val max = max(x1, x2)
        (min..max).map { Point(it, point1.y) }.toList()
    } else {
        listOf()
    }
}

fun buildVentMap(lineList: List<Line>): VentMap {
    val pointList = lineList.flatMap { buildPointList(it) }
    return pointList.groupingBy { it }.eachCount()
}
