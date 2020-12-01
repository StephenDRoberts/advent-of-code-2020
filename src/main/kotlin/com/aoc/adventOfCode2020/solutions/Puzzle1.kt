package com.aoc.adventOfCode2020.solutions

import org.springframework.stereotype.Component
import java.io.File

@Component
class Puzzle1 {

    fun findSolution(inputPuzzle: String): Int {
        var answer = 0

        val prefix = "/Users/sro01/Documents/002_PersonalCode/adventOfCode2020/src/main/kotlin/com/aoc/adventOfCode2020/inputs/"
        val filepath = "${prefix}${inputPuzzle}"

        val inputArray = readFileLineByLineUsingForEachLine(filepath)
                        .sortedDescending()

        for (element in inputArray) {
            val seedNumber = element
            val seedSolution = inputArray.find { it == 2020 - seedNumber }
            if (seedSolution != null) {
                println("Numbers: $seedNumber, $seedSolution")
                println("Answer: ${seedNumber * seedSolution}")
                answer = seedNumber * seedSolution
                break
            }
        }
        return answer
    }

    fun readFileLineByLineUsingForEachLine(fileName: String): List<Int> {
        val list = mutableListOf<Int>()
        File(fileName).forEachLine { it -> list.add(it.toInt()) }
        return list
    }


}