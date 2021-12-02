
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