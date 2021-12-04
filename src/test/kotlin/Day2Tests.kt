import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.file.Paths

@DisplayName("Day 2 Tests")
class Day2Tests {

    private fun parseSubmarineCommand(rawCommand: String): SubmarineCommand {
        val (commandType, rawDelta) = rawCommand.split(" ")
        val delta = rawDelta.toInt()
        return when(commandType) {
            "forward" -> SubmarineCommand(CommandType.FORWARD, delta)
            "up" -> SubmarineCommand(CommandType.UP, delta)
            "down" -> SubmarineCommand(CommandType.DOWN, delta)
            else -> throw Error("Could not parse $rawCommand")
        }
    }

    @Test
    @DisplayName("Six commands should end up at position(15,10)")
    fun should_have_position_after_six_commands(){
        val command1 = SubmarineCommand(CommandType.FORWARD, 5)
        val command2 = SubmarineCommand(CommandType.DOWN, 5)
        val command3 = SubmarineCommand(CommandType.FORWARD, 8)
        val command4 = SubmarineCommand(CommandType.UP, 3)
        val command5 = SubmarineCommand(CommandType.DOWN, 8)
        val command6 = SubmarineCommand(CommandType.FORWARD, 2)
        val commandList = listOf(command1, command2, command3,
                                    command4, command5, command6)
        val newPosition = moveSubmarine(commandList)
        val expectedPosition = Position(15,10)
        assertEquals(expectedPosition, newPosition)
    }

    @Test
    @DisplayName("1000 commands should give correct position")
    fun should_have_position_after_1000_commands() {
        val path = Paths.get("src/test/kotlin/Day2Big.txt")
        val stringList = readStringListFromPath(path)
        val commandList = stringList.map { parseSubmarineCommand(it) }
        val newPosition = moveSubmarine(commandList)
        val expectedPosition = Position(1965,1182)
        assertEquals(expectedPosition, newPosition)
    }
}