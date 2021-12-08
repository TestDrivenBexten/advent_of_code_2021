
fun calculateFuelToPosition(positionList: List<Int>, position: Int): Int {
    val fuelSpentList = positionList.map { kotlin.math.abs(it - position) }
    return fuelSpentList.sum()
}

fun calculateFuel(positionList: List<Int>): Int {
    return 0
}