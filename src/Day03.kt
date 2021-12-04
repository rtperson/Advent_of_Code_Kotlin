fun main() {

    fun countBitN(input: List<String>, n: Int): Int {
        var ones = 0
        var zeroes = 0
        for (y in input.indices) {
            when (input[y][n]) {
                '0' -> zeroes++
                '1' -> ones++
            }
        }
        if (zeroes > ones) return 0 else return 1
    }

    fun gammaToEpsilon(gamma: String) : String {
        var epsilon = ""
        for (x in gamma.indices) {
            when (gamma[x]) {
                '0' -> epsilon += "1"
                '1' -> epsilon += "0"
            }
        }
        return epsilon
    }

    fun filterOnPosition(input: List<String>, pos: Int, num: Char): List<String> {
        return input.filter{ it[pos] == num }
    }

    fun part1(input: List<String>): Int {
        var gamma = ""
        for (x in input[0].indices) {
            val newbit = countBitN(input, x)
            gamma += newbit
        }
        val epsilon = gammaToEpsilon(gamma)
        println("gamma: $gamma, epsilon: $epsilon")
        return gamma.toInt(2) * epsilon.toInt(2)
    }


    fun part2(input: List<String>): Int {
        var o2 = input
        var x = 0
        while (o2.size > 1) {
            when(countBitN(o2, x)) {
                1 -> o2 = filterOnPosition(o2, x++, '1')
                0 -> o2 = filterOnPosition(o2, x++, '0')
            }
        }

        var co2 = input
        x = 0
        while (co2.size > 1) {
            when(countBitN(co2, x)) {
                1 -> co2 = filterOnPosition(co2, x++, '0')
                0 -> co2 = filterOnPosition(co2, x++, '1')
            }
        }

        return o2[0].toInt(2) * co2[0].toInt(2)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(countBitN(testInput, 0) == 1)
    println(filterOnPosition(testInput, 0, '1'))
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)


//    println(part2(testInput) )
//    check(part2(testInput) == 198)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}