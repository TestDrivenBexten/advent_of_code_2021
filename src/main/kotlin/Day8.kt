
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

private fun findInputOfLength(inputList: List<String>, length: Int): List<String> {
    return listOfNotNull(inputList.find { it.length == length })
}

fun decipherInputOutput(inputOutput: InputOutput): Int {
    val inputList = inputOutput.inputList
    val outputList = inputOutput.outputList
    val allList = inputList + outputList

    // Find easy values
    val oneInput = findInputOfLength(allList,2)[0].toList().toSet()
    val fourInput = findInputOfLength(allList,4)[0].toList().toSet()
    val sevenInput = findInputOfLength(allList,3)[0].toList().toSet()
    val eightInput = findInputOfLength(allList,7)[0].toList().toSet()

    // Find top character
    val topCharacter = sevenInput.minus(oneInput).toList()[0]

    // Gather 0, 6 and 9 candidates
    val sixDigitCandidateList = allList.filter { it.length == 6 }.map{ it.toList().toSet() }
    val sixInput = sixDigitCandidateList.find {
        sevenInput.minus(it).size == 1
    }?.toList()?.toSet()

    // Find more characters
    val upperRightCharacter = sevenInput.minus(sixInput).toList()[0]
    val bottomRightCharacter = oneInput.minus(upperRightCharacter).toList()[0]

    // Find 2, 3 and 5
    val fiveDigitCandidateList = allList.filter { it.length == 5 }.map{ it.toList().toSet() }
    val threeInput = fiveDigitCandidateList.find {
        it.containsAll(sevenInput)
    }?.toList()?.toSet()
    val twoInput = fiveDigitCandidateList.find {
        it.contains(upperRightCharacter) && !it.contains(bottomRightCharacter)
    }?.toList()?.toSet()
    val fiveInput = fiveDigitCandidateList.find {
        !it.contains(upperRightCharacter) && it.contains(bottomRightCharacter)
    }?.toList()?.toSet()

    // Find bottom left character
    val bottomLeftCharacter = sixInput!!.minus(fiveInput).toList()[0]

    // Find 0 and 9
    val zeroInput = sixDigitCandidateList.find {
        !it.containsAll(sixInput) && it.contains(bottomLeftCharacter)
    }?.toList()?.toSet()
    val nineInput = sixDigitCandidateList.find {
        !it.contains(bottomLeftCharacter)
    }?.toList()?.toSet()

    fun convertCharSetToDigit(charSet: Set<Char>): Int {
        return when(charSet) {
            zeroInput -> 0
            oneInput -> 1
            twoInput -> 2
            threeInput -> 3
            fourInput -> 4
            fiveInput -> 5
            sixInput -> 6
            sevenInput -> 7
            eightInput -> 8
            nineInput -> 9
            else -> -1
        }
    }

    val rawNumberList = outputList.map { rawString ->
        val charSet = rawString.toSet()
        convertCharSetToDigit(charSet)
    }
    println(rawNumberList)

    return 0
}

fun decipherDigits(inputOutputList: List<InputOutput>): List<Int> {
    return inputOutputList.map { decipherInputOutput(it) }
}
