package com.aoc.adventOfCode2020.solutions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Puzzle9Test {

    val underTest = Puzzle9()

        @Test
        fun `should return Seat ID 357 for FBFBBFFRLR`() {
            val solution = underTest.checkSeat("FBFBBFFRLR")
            assertThat(solution).isEqualTo(357.toDouble())
        }

        @Test
        fun `should return Seat ID 567 for BFFFBBFRRR`() {
            val solution = underTest.checkSeat("BFFFBBFRRR")
            assertThat(solution).isEqualTo(567.toDouble())
        }

        @Test
        fun `should return Seat ID 119 for FFFBBBFRRR`() {
            val solution = underTest.checkSeat("FFFBBBFRRR")
            assertThat(solution).isEqualTo(119.toDouble())
        }

        @Test
        fun `should return Seat ID 820 for BBFFBBFRLL`() {
            val solution = underTest.checkSeat("BBFFBBFRLL")
            assertThat(solution).isEqualTo(820.toDouble())
        }






    @Test
    fun `should find puzzle Solution`() {
        val prefix = "/Users/sro01/Documents/002_PersonalCode/adventOfCode2020/src/main/kotlin/com/aoc/adventOfCode2020/inputs/"
        val inputPuzzle = "inputDay5.txt"

        val solution = underTest.findSolution("${prefix}${inputPuzzle}")
//        val puzzleArray = readFileLineByLineUsingForEachLine("${prefix}${inputPuzzle}")
    }
}