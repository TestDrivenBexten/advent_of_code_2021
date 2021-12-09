
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

data class InputOutput(val inputList: List<String>, val outputList: List<String>)

fun decipherDigits(outputList: List<InputOutput>): List<Int> {
    return listOf(0)
}
