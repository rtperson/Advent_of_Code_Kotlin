fun main() {

    fun mapToPairs(input: List<String>) : List<Pair<String, Int>> =
        input.map {
            val (d, x) = it.split(" ")
            Pair(d, x.toInt())
        }

    fun computeDistance(orders: List<String>): List<Int> {
        var horizontalPosition = 0
        var depth = 0

        for (dir in orders) {
            val d = dir.split(" ")
            val n = d[1].toInt()
            when(d.first()) {
                "down" -> {
                    depth += n
                }
                "up" -> {
                    depth -= n
                }
                "forward" -> {
                    horizontalPosition += n
                }
            }
        }

        return listOf(horizontalPosition, depth)
    }

    fun computeAim(orders: List<String>): List<Int> {
        var horizontalPosition = 0
        var depth = 0
        var aim = 0


        for (dir in orders) {
            val d = dir.split(" ")
            val n = d[1].toInt()
            when (d.first()) {
                "down" -> {
                    aim += n
                }
                "up" -> {
                    aim -= n
                }
                "forward" -> {
                    horizontalPosition += n
                    depth += ( aim * n )
                }
            }
        }

        return listOf(horizontalPosition, depth)
    }

    fun part1(input: List<String>): Int {
        val res = computeDistance(input)
        return res[0] * res[1]
    }

    fun part2(input: List<String>): Int {
        val res = computeAim(input)
        return res[0] * res[1]
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    println(part1(testInput) )
    check(part1(testInput) == 150)

    println(part2(testInput))
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}