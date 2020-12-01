//package com.aoc.adventOfCode2020.solutions
//
//import org.springframework.stereotype.Component
//import java.io.File
//
//@Component
//class Puzzle1 {
//
//    val prefix = "/Users/sro01/Documents/002_PersonalCode/adventOfCode2020/src/main/kotlin/com/aoc/adventOfCode2020/inputs/"
//    val puzzle = "input1.txt"
//
//    init {
//
//        val inputArray = readFileLineByLineUsingForEachLine("${prefix}${puzzle}")
//                .sortedDescending()
//
//        for(i in 0..inputArray.size) {
//            val seedNumber = inputArray[i]
//            val seedSolution = inputArray.find { it == 2020 - seedNumber }
//            if(seedSolution != null){
//                println("Numbers: $seedNumber, $seedSolution")
//                println("Answer: ${seedNumber * seedSolution}")
//                break
//            }
//        }
//    }
//
//    fun readFileLineByLineUsingForEachLine(fileName: String): List<Int> {
//        val list = mutableListOf<Int>()
//        File(fileName).forEachLine { it -> list.add(it.toInt()) }
//        return list
//    }
//
//
//}