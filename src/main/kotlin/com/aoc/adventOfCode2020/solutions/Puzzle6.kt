//package com.aoc.adventOfCode2020.solutions
//
//import org.springframework.stereotype.Component
//import java.io.File
//import kotlin.math.ceil
//
//@Component
//class Puzzle6 {
//    init {
//        val prefix = "/Users/sro01/Documents/002_PersonalCode/adventOfCode2020/src/main/kotlin/com/aoc/adventOfCode2020/inputs/"
//        val inputPuzzle = "inputDay3.txt"
//        val pathRows = readFileLineByLineUsingForEachLine("${prefix}${inputPuzzle}")
//
//        val routes = mutableListOf<Route>()
//
//        routes.add(Route(1,1))
//        routes.add(Route(3,1))
//        routes.add(Route(5,1))
//        routes.add(Route(7,1))
//        routes.add(Route(1,2))
//
//        var treesHitPerSlope = mutableListOf<Int>()
//
//        for(route in routes) {
//            val rowsInOnePuzzle = pathRows.size.toDouble()
//
//            val columnsInOnePuzzle = pathRows[0].chunked(1).size.toDouble()
//            val numOfRowsReachedInPuzzle = rowsInOnePuzzle / route.down
//            val numOfLateralMovementsNeeded = route.right * numOfRowsReachedInPuzzle
//
//            val numOfRepeatPatternsNeeded = ceil( numOfLateralMovementsNeeded / columnsInOnePuzzle).toInt()
//
//            val fullPuzzle = pathRows.map { row -> row.repeat(numOfRepeatPatternsNeeded) }
//
//            var stepsTaken = mutableListOf<String>()
//            for (i in route.down until fullPuzzle.size step route.down) {
//                stepsTaken.add(fullPuzzle[i].chunked(1)[route.right * (i/route.down)])
//            }
//            println(stepsTaken.filter { it == "#" }.size)
//            treesHitPerSlope.add(stepsTaken.filter { it == "#" }.size)
//        }
//        println(treesHitPerSlope.reduce { acc, i -> acc * i })
//    }
//
//
//    fun readFileLineByLineUsingForEachLine(fileName: String): List<String> {
//        val list = mutableListOf<String>()
//        File(fileName).forEachLine { it -> list.add(it) }
//        return list
//    }
//}
//
//data class Route(val right: Int, val down: Int)