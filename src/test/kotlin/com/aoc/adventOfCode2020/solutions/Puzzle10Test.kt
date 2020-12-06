package com.aoc.adventOfCode2020.solutions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Puzzle10Test {

    val underTest = Puzzle10()


    @Test
    fun `should find puzzle Solution`() {
        val prefix = "/Users/sro01/Documents/002_PersonalCode/adventOfCode2020/src/main/kotlin/com/aoc/adventOfCode2020/inputs/"
        val inputPuzzle = "inputDay5.txt"

        val solution = underTest.findSolution("${prefix}${inputPuzzle}")
//        val puzzleArray = readFileLineByLineUsingForEachLine("${prefix}${inputPuzzle}")
    }
}