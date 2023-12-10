fun main() {

    //pls dont judge trash code
        val testInput = readInput("Day01_test")

        var newList = part2(input = testInput)
//        print(newList)
        print(newList)
//        print(part1(part2(testInput)).sumOf { it.toInt() })

}


fun part1(input: List<String>): List<String> {
    var newList = mutableListOf<String>()
    for (line in input) {
        var clean = (line.filter { it.isDigit() })
        if (clean.length > 2){
            clean = "${clean.first()}${clean.last()}"
        }
        if (clean.length < 2){
            clean = "${clean.first()}${clean.first()}"
        }
        newList.add(clean)
    }

    return newList
}

val numWords = listOf(
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
)
fun getLastDigit(line: String): Int {
    for (index in line.lastIndex downTo 0) {
        val c = line[index]

        if (c.isDigit()) {
            return c.digitToInt()
        }

        numWords.forEachIndexed { numStringIndex, numString ->
            if (line.substring(index).startsWith(numString)) {
                return numStringIndex + 1
            }
        }
    }

    return -1
}
fun getFirstDigit(line: String): Int {
    line.forEachIndexed { index, c ->
        if (c.isDigit()) {
            return c.digitToInt()
        }

        numWords.forEachIndexed { numStringIndex, numString ->
            if (line.substring(index).startsWith(numString)) {
                return numStringIndex + 1
            }
        }
    }

    return -1
}



fun part2(input: List<String>): Int {
    return input.sumOf { line ->
        val firstDigit = getFirstDigit(line)
        val lastDigit = getLastDigit(line)

        (firstDigit * 10) + lastDigit
    }
}