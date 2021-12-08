
fun calculateFuelToPosition(positionList: List<Int>, position: Int): Int {
    val fuelSpentList = positionList.map { kotlin.math.abs(it - position) }
    return fuelSpentList.sum()
}

fun calculateFuel(positionList: List<Int>): Int {
    val min = positionList.minOrNull() ?: Int.MAX_VALUE
    val max = positionList.maxOrNull() ?: Int.MIN_VALUE
    val fuelSpentList = (min..max).map { Pair(it, calculateFuelToPosition(positionList, it)) }
    return fuelSpentList.minByOrNull { it.second }?.second ?: 0
}

fun calculateOddFuelToPosition(positionList: List<Int>, position: Int): Int {
    val fuelSpentList = positionList.map { it ->
        val moveDistance = kotlin.math.abs(it - position)
        (1..moveDistance).sum()
    }
    return fuelSpentList.sum()
}

fun calculateOddFuel(positionList: List<Int>): Int {
    val min = positionList.minOrNull() ?: Int.MAX_VALUE
    val max = positionList.maxOrNull() ?: Int.MIN_VALUE
    val fuelSpentList = (min..max).map {
        Pair(it, calculateOddFuelToPosition(positionList, it))
    }
    return fuelSpentList.minByOrNull { it.second }?.second ?: 0
}