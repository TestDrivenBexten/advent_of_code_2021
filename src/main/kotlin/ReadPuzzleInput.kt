import java.nio.file.Files
import java.nio.file.Path

fun readIntListFromPath(path: Path): List<Int> {
    return Files.readAllLines(path).map { it.toInt() }
}

fun readStringListFromPath(path: Path): List<String> {
    return Files.readAllLines(path)
}

fun readLongListFromPath(path: Path): List<Long> {
    return Files.readAllLines(path).map { it.toLong() }
}