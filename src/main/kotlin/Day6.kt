
data class LanternFish(val age: Int, val oldFish: Boolean)

typealias AgeCount = Map<Int,Long> // Age to Count

fun mergeMap(map1: AgeCount, map2: AgeCount): AgeCount {
    return (map1.keys + map2.keys).associateWith { key ->
        listOfNotNull(map1[key], map2[key]).sum()
    }
}

fun advanceDayCount(fishAgeMap: AgeCount): AgeCount {
    val ageCountList = fishAgeMap.entries.map { (key, value) ->
        when(key){
            0 -> mapOf(6 to value, 8 to value)
            else -> mapOf(key - 1 to value)
        }
    }
    return ageCountList.reduce { acc, ageMap -> mergeMap(acc, ageMap)}
}

fun advanceDay(fishList: List<LanternFish>): List<LanternFish> {
    fun ageFish(fish: LanternFish): List<LanternFish> {
        return if(fish.age == 0){
            val oldFish = LanternFish(6, true)
            val newFish = LanternFish(8, false)
            listOf(oldFish, newFish)
        } else {
            listOf(LanternFish(fish.age - 1, fish.oldFish))
        }
    }
    return fishList.flatMap { ageFish(it) }
}

fun advanceByDays(fishList: List<LanternFish>, days: Int): List<LanternFish> {
    return if(days == 0) {
        fishList
    } else {
        val newFishList = advanceDay(fishList)
        advanceByDays(newFishList, days - 1)
    }
}

fun countFishByDays(fishList: List<LanternFish>, days: Int): Long {
    val ageGroupCountInt = fishList.groupingBy { it.age }.eachCount()
    val ageGroupCount = ageGroupCountInt.entries.associate {
        (key, value) -> key to value.toLong()
    }
    var dayCountdown = days
    var ageCount = ageGroupCount
    while(dayCountdown > 0) {
        println(dayCountdown)
        ageCount = advanceDayCount(ageCount)
        println(ageCount)
        dayCountdown--
    }
    return ageCount.values.sum()
}