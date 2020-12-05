package com.aoc.adventOfCode2020.solutions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Puzzle1Test {
    val underTest = Puzzle1()


    @Test
    fun `should provide answer to puzzle`() {
        val answer = underTest.findSolution("inputDay1.txt")
        assertThat(answer).isEqualTo(913824)
    }
}