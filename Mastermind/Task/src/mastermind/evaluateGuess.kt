package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    val controlBol = booleanArrayOf(false, false, false, false)
    val controlBol2 = booleanArrayOf(false, false, false, false)

    fun getSamePosition(s1: String, s2: String): Int {
        var samePosition = 0
        for ((index, value) in s2.withIndex()) {
            for ((index2, value2) in s1.withIndex()) {
                if (index == index2 && value == value2) {
                    samePosition++
                    controlBol[index] = true
                    controlBol2[index] = true
                }
            }
        }
        return samePosition
    }

    fun getWrongPosition(s1: String, s2: String): Int {
        var wrongPosition = 0

        for ((index, value) in s1.withIndex()) {
            for ((index2, value2) in s2.withIndex()) {
                if (index != index2 && value2 == value && !controlBol[index] && !controlBol2[index2]) {
                    wrongPosition++
                    controlBol[index] = true
                    controlBol2[index2] = true
                }
            }
        }
        return wrongPosition
    }
    return Evaluation(getSamePosition(secret, guess), getWrongPosition(secret, guess))
}
