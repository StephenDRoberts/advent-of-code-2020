package com.aoc.adventOfCode2020.solutions

import org.springframework.stereotype.Component
import java.io.File

@Component
class Puzzle2 {

    fun findSolution(inputPuzzle: String): Int {
        var answer = 0;
        val prefix = "/Users/sro01/Documents/002_PersonalCode/adventOfCode2020/src/main/kotlin/com/aoc/adventOfCode2020/inputs/"

        val inputArray = readFileLineByLineUsingForEachLine("${prefix}${inputPuzzle}")
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
                        answer = initialSeed * seedNumber * seedSolution
                        println("Numbers: $initialSeed, $seedNumber, $seedSolution")
                        println("Answer: $answer")
                        break@loop
                    }
                }
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