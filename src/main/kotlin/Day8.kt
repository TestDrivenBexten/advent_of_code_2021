
fun countUniqueOutputList(outputList: List<String>): Int {
    val numberList = outputList.flatMap { it.split(" ") }
    val count = numberList.count { number ->
        when(number.length) {
            2 -> true
            3 -> true
            4 -> true
            7 -> true
            else -> false
        }
    }
    return count
}