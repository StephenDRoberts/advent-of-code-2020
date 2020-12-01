package com.aoc.adventOfCode2020.solutions

import org.springframework.stereotype.Component
import java.io.File

@Component
class Puzzle2 {

    val prefix = "/Users/sro01/Documents/002_PersonalCode/adventOfCode2020/src/main/kotlin/com/aoc/adventOfCode2020/inputs/"
    val puzzle = "input1.txt"

    init {

        val inputArray = readFileLineByLineUsingForEachLine("${prefix}${puzzle}")
                .sortedDescending()

        loop@ for(element in inputArray) {
            val initialSeed = element
            val newSolutionNumber = 2020 - initialSeed
            val filteredArray = inputArray.filter { it < newSolutionNumber }

            if (filteredArray.size >= 2) {
                for (element in filteredArray) {
                    val seedNumber = element
                    val seedSolution = filteredArray.find { it == newSolutionNumber - seedNumber }
                    if (seedSolution != null) {
                        println("Numbers: $initialSeed, $seedNumber, $seedSolution")
                        println("Answer: ${initialSeed * seedNumber * seedSolution}")
                        break@loop
                    }
                }
            }
        }
    }

    fun readFileLineByLineUsingForEachLine(fileName: String): List<Int> {
        val list = mutableListOf<Int>()
        File(fileName).forEachLine { it -> list.add(it.toInt()) }
        return list
    }


}