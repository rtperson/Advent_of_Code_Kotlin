fun main() {
    val answer = readInput("Day02_test").sortedBy{ it.toString() }
    answer.map{ it.split(" ")}
    println(answer)
    println(answer.map{
        var amt = 0
        var dir = ""
        val dist: List<String> = it.split(" ")
        dist.map{ num: String ->
            amt = dist[1].toInt()

        }
    })

}



fun day2() {

}