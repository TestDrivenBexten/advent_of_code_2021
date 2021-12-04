import kotlin.math.pow

typealias BitList = List<Int>
typealias BinaryList = List<BitList>

private fun findCommonBitList(binaryList: BinaryList): BitList {
    val numberCount = binaryList.size
    val numberLength = binaryList[0].size
    val columnBitList = (0 until numberLength).map { index ->
        binaryList.map {
            binaryNumber -> binaryNumber[index]
        }
    }
    val commonBitList = columnBitList.map {
        val zeroCount = it.count { bit -> bit == 0 }
        val oneCount = numberCount - zeroCount
        if (oneCount > zeroCount) 1 else 0
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
