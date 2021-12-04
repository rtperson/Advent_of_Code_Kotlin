fun main() {
    fun part1(input: List<String>): Int {
        var lastNum = 20000000
        var bigger = 0
        for ( num in input ) {
            if (num.toInt() > lastNum) bigger += 1
            lastNum = num.toInt()
        }
        return bigger
    }

    fun part2BruteForce(input: List<String>): Int {
        var lastNum = 20000000
        var bigger = 0
        for ( (index, num) in input.withIndex() ) {
            var sum = 0
            if ( index == input.size - 1 ) {
                sum = num.toInt()
            } else if ( index == input.size - 2 ) {
                sum = num.toInt() + input[index + 1]!!.toInt()
            } else {
                sum = num.toInt() + input[index + 1]!!.toInt() + input[index + 2]!!.toInt()
            }
            if (sum > lastNum) {
                bigger++
            }
            lastNum = sum
        }
        return bigger
    }

    fun part2(input: List<String>): Int {
        return input
            .map { it.toInt()}
            .windowed(3)
            .map { it.sum() }
            .windowed(2)
            .count { it[0] < it[1] }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    println(part2(testInput) )
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    //println(part1(input))
    println(part2(input))
}
