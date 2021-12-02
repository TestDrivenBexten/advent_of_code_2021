
fun countGreaterMeasurements(measureList: List<Int>): Int {
    var greaterCount = 0
    for(x in 0 until measureList.size - 1){
        val current = measureList[x]
        val next = measureList[x + 1]
        if(next > current) {
            greaterCount += 1
        }
    }
    return greaterCount
}

fun countGreaterWindows(measureList: List<Int>): Int {
    val windowList = mutableListOf<Int>()
    for (x in 2 until measureList.size) {
        val m1 = measureList[x - 2]
        val m2 = measureList[x - 1]
        val m3 = measureList[x]
        windowList.add(m1 + m2 + m3)
    }
    return countGreaterMeasurements(windowList)
}