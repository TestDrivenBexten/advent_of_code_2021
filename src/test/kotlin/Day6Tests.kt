import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.file.Paths

@DisplayName("Day 6 Tests")
class Day6Tests {
    @Test
    @DisplayName("Should solve for small fish pool")
    fun should_solve_for_small_fish_pool() {
        val path = Paths.get("src/test/kotlin/Day6Small.txt")
        val stringList = readStringListFromPath(path)[0].split(",")
        val fishList = stringList.map { LanternFish(it.toInt(), true) }
        val newFishList = advanceByDays(fishList, 80)
        assertEquals(5934,newFishList.size)
    }

    @Test
    @DisplayName("Should solve for large fish pool")
    fun should_solve_for_large_fish_pool() {
        val path = Paths.get("src/test/kotlin/Day6Big.txt")
        val stringList = readStringListFromPath(path)[0].split(",")
        val fishList = stringList.map { LanternFish(it.toInt(), true) }
        val newFishList = advanceByDays(fishList, 80)
        assertEquals(343441,newFishList.size)
    }

    @Test
    @DisplayName("Should solve for small immortal fish pool")
    fun should_solve_for_small_immortal_fish_pool() {
        val path = Paths.get("src/test/kotlin/Day6Small.txt")
        val stringList = readStringListFromPath(path)[0].split(",")
        val fishList = stringList.map { LanternFish(it.toInt(), true) }
        val fishCount = countFishByDays(fishList, 256)
        assertEquals(26_984_457_539,fishCount)
    }

    @Test
    @DisplayName("Should solve for large immortal fish pool")
    fun should_solve_for_large_immortal_fish_pool() {
        val path = Paths.get("src/test/kotlin/Day6Big.txt")
        val stringList = readStringListFromPath(path)[0].split(",")
        val fishList = stringList.map { LanternFish(it.toInt(), true) }
        val fishCount = countFishByDays(fishList, 256)
        assertEquals(1_569_108_373_832,fishCount)
    }
}