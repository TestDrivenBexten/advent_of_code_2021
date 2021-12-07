
data class LanternFish(val age: Int, val oldFish: Boolean)

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