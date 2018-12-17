package mastermind

import org.junit.Assert
import org.junit.Test

class MastermindTests {

    private fun testEvaluation(secret: String, guess: String, positions: Int, letters: Int) {
        val expected = Evaluation(positions, letters)
        val evaluation = evaluateGuess(secret, guess)
        Assert.assertEquals("Wrong evaluation for secret=$secret, guess=$guess",
                expected, evaluation)
    }

    @Test
    fun specialCase1() = testEvaluation("ADFE", "AABC", 1, 0)

    //secret=FBAE, guess=CBFE expected:<Evaluation(rightPosition=2, wrongPosition=1

    @Test
    fun specialCase2() = testEvaluation("FBAE", "CBFE", 2, 1)

    //secret=AABC, guess=ADFA expected:<Evaluation(rightPosition=1, wrongPosition=1

    @Test
    fun specialCase3() = testEvaluation("AABC", "ADFA", 1, 1)

    //secret=CFDF, guess=FCCD expected:<Evaluation(rightPosition=0, wrongPosition=3

    @Test
    fun specialCase4() = testEvaluation("CFDF", "FCCD", 0, 3)

    //secret=BDAD, guess=AAAE expected:<Evaluation(rightPosition=1, wrongPosition=0
    @Test
    fun specialCase5() = testEvaluation("BDAD", "AAAE", 1, 0)

    //secret=DAAE, guess=AABC expected:<Evaluation(rightPosition=1, wrongPosition=1
    @Test
    fun specialCase6() = testEvaluation("DAAE", "AABC", 1, 1)

    // simple
    @Test
    fun testEqual() = testEvaluation("ABCD", "ABCD", 4, 0)

    @Test
    fun testOnlyWrongPositions() = testEvaluation("DCBA", "ABCD", 0, 4)

    @Test
    fun testSwap() = testEvaluation("ABCD", "ABDC", 2, 2)

    @Test
    fun testRightPositions() = testEvaluation("ABCD", "ABCF", 3, 0)

    @Test
    fun testWrongPositions() = testEvaluation("DAEF", "FECA", 0, 3)


    // repeated letters
    @Test
    fun testRightPosition() = testEvaluation("AABC", "ADFE", 1, 0)

    @Test
    fun testSameLetters() = testEvaluation("AABC", "DEAA", 0, 2)
}