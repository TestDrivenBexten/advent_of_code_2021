import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.nio.file.Paths
import java.util.concurrent.TimeUnit

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
}