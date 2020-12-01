package com.aoc.adventOfCode2020.solutions

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class Puzzle2Test {
    val underTest = Puzzle2()

    @Test
    fun `should provide answer to puzzle`() {
        val answer = underTest.findSolution("input1.txt")
        Assertions.assertThat(answer).isEqualTo(240889536)
    }
}