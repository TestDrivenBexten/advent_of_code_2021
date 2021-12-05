import kotlin.math.pow

typealias BitList = List<Int>
typealias BinaryList = List<BitList>

private fun findColumnBitList(binaryList: BinaryList): List<BitList> {
    val numberLength = binaryList[0].size
    val columnBitList = (0 until numberLength).map { index ->
        binaryList.map {
            binaryNumber -> binaryNumber[index]
        }
    }
    return columnBitList
}

private fun findCommonBitList(binaryList: BinaryList): BitList {
    val numberCount = binaryList.size
    val columnBitList = findColumnBitList(binaryList)
    val commonBitList = columnBitList.map {
        val zeroCount = it.count { bit -> bit == 0 }
        val oneCount = numberCount - zeroCount
        if (oneCount >= zeroCount) 1 else 0
    }
    return commonBitList
}

private fun binaryToDecimal(bitList: BitList): Int {
    return bitList.reversed().reduceIndexed { index, acc, bit ->
        if (bit == 1) {
            acc + 2.0.pow(index).toInt()
        } else {
            acc
        }
    }
}

fun calculatePowerConsumption(binaryList: BinaryList): Int {
    val commonBitList = findCommonBitList(binaryList)
    val infrequentBitList = commonBitList.map { if (it == 0) 1 else 0 }
    val gammaRate = binaryToDecimal(commonBitList)
    val epsilonRate = binaryToDecimal(infrequentBitList)
    return gammaRate * epsilonRate
}

private fun filterByColumnBit(column: Int,
                              bit: Int, binaryList: BinaryList): BinaryList {
    return binaryList.filter { bitList -> bitList[column] == bit }
}

private fun calculateOxygenRating(binaryList: BinaryList): Int {
    val columnCount = binaryList[0].size

    val filteredBinaryList = (0 until columnCount).fold(binaryList) { acc, column ->
        val commonBitList = findCommonBitList(acc)
        val commonBit = commonBitList[column]
        filterByColumnBit(column, commonBit, acc)
    }
    val rawBinary = filteredBinaryList[0]
    return binaryToDecimal(rawBinary)
}

private fun calculateScrubberRating(bitList: BitList): Int {
    return 0
}

fun calculateLifeSupportRating(binaryList: BinaryList): Int {
    val commonBitList = findCommonBitList(binaryList)
    val infrequentBitList = commonBitList.map { if (it == 0) 1 else 0 }
    val oxygenRating = calculateOxygenRating(binaryList)
    val scrubberRating = calculateScrubberRating(infrequentBitList)
    return oxygenRating + scrubberRating
}
