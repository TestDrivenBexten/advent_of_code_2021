enum class CommandType {
    FORWARD,
    UP,
    DOWN
}

data class SubmarineCommand(val commandType: CommandType, val magnitude: Int)
data class Position(val horizontal: Int, val depth: Int)
data class AimPosition(val aim: Int, val position: Position)

private fun executeCommand(position: Position,
                           command: SubmarineCommand): Position {
    val x = position.horizontal
    val y = position.depth
    val delta = command.magnitude
    return when(command.commandType) {
        CommandType.FORWARD -> Position(x + delta, y)
        CommandType.UP -> Position(x, y - delta)
        CommandType.DOWN -> Position(x, y + delta)
    }
}

fun moveSubmarine(commandList: List<SubmarineCommand>): Position {
    val initialPosition = Position(0,0)
    return commandList.fold(initialPosition) {
            previousPosition, command -> executeCommand(previousPosition, command)
    }
}

private fun executeAimCommand(aimPosition: AimPosition,
                           command: SubmarineCommand): AimPosition {
    val (aim, position) = aimPosition
    val x = position.horizontal
    val y = position.depth
    val delta = command.magnitude
    return when(command.commandType) {
        CommandType.FORWARD -> {
            val newDepth = y + (aim * delta)
            val newPosition = Position(x + delta, newDepth)
            AimPosition(aim, newPosition)
        }
        CommandType.UP -> AimPosition(aim - delta, position)
        CommandType.DOWN -> AimPosition(aim + delta, position)
    }
}

fun aimMoveSubmarine(commandList: List<SubmarineCommand>): AimPosition {
    val initialPosition = AimPosition(0, Position(0,0))
    return commandList.fold(initialPosition) {
            previousPosition, command -> executeAimCommand(previousPosition, command)
    }
}