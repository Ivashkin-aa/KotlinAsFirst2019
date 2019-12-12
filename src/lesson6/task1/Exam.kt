package lesson6.task1

import java.lang.IllegalArgumentException

fun exam(sum: Double, coins: String): List<Pair<Int, String>> {
    if (!coins.matches(Regex("""((0.)?\d+, )* \d+""")) || (coins == ""))
        throw IllegalArgumentException()
    val coin = coins.split(", ")
    val nominal = mutableListOf<Pair<Int, String>>()
    if (!sum.toString().matches(Regex("""\d+\.?\d?\d?""")) || (sum.toString() == ""))
        throw IllegalArgumentException()
    var i = 0
    var newSum = sum
    while (i < coin.size) {
        var col = 0
        if (newSum - coin[i].toDouble() >= 0) {
            while (newSum - coin[i].toDouble() >= 0) {
                newSum -= coin[i].toDouble()
                col++
            }
            nominal += col to coin[i]
        }
        i++
    }
    return nominal
}