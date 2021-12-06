import kotlin.math.abs
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

private fun buildDiagonalPointList(line: Line): List<Point> {
    val (point1, point2) = line
    val (x1, y1) = point1
    val (x2, y2) = point2
    return if(abs(x1 - x2) == abs(y1 - y2)) {
        return if(x1 > x2 && y1 < y2) {
            (x1 downTo x2).mapIndexed { index, x -> Point(x, y1 + index) }
        } else if(x1 > x2 && y1 > y2) {
            (x1 downTo x2).mapIndexed { index, x -> Point(x, y1 - index) }
        } else if(x1 < x2 && y1 < y2) {
            (x1..x2).mapIndexed { index, x -> Point(x, y1 + index) }
        } else {
            (x1..x2).mapIndexed { index, x -> Point(x, y1 - index)}
        }
    } else {
        listOf()
    }
}

fun buildVentMap(lineList: List<Line>): VentMap {
    val pointList = lineList.flatMap { buildPointList(it) }
    return pointList.groupingBy { it }.eachCount()
}

fun buildDiagonalVentMap(lineList: List<Line>): VentMap {
    val diagonalPointList = lineList.flatMap { buildDiagonalPointList(it) }
    val pointList = lineList.flatMap { buildPointList(it) }
    val allPointList = diagonalPointList + pointList
    return allPointList.groupingBy { it }.eachCount()
}