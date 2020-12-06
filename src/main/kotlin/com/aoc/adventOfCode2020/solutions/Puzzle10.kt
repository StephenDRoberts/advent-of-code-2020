package com.aoc.adventOfCode2020.solutions

import org.springframework.stereotype.Component
import java.io.File

@Component
class Puzzle10 {

    fun findSolution(file: String){
        val puzzleArray = readFileLineByLineUsingForEachLine(file)
        val listOfSeatIDs = mutableListOf<Double>()

        for(row in puzzleArray) {
            val solution = checkSeat(row)
            listOfSeatIDs.add(solution)

        }
        val sorted = listOfSeatIDs.sorted()
        val missing = checkMissingSeat(sorted)
        println(missing)
    }

    fun checkMissingSeat(seats: List<Double>) : Double {
        val missing = seats.filterIndexed { index, d -> seats[index] - seats[Math.max(index -1,0)]>1 }
        return missing[0] -1
    }

    fun checkSeat(pattern: String) : Double {
        val chunked = pattern.chunked(1)
        val rowPattern = chunked.slice(IntRange(0,6))
        val seatPattern = chunked.slice(IntRange(7,9))

        val rowNumber = checkSeat(rowPattern, 0.toDouble(), Math.pow(2.toDouble(),(rowPattern.size).toDouble())-1)
        val seatNumber = checkSeat(seatPattern, 0.toDouble(), Math.pow(2.toDouble(),(seatPattern.size).toDouble())-1)

        val seatID = (rowNumber * 8) + seatNumber
        return seatID
    }

    fun checkSeat(pattern: List<String>, minNum: Double, maxNum: Double): Double {
        val halfway = (maxNum + 1 - minNum) / 2 + minNum
        var newMaxNum: Double
        var newMinNum: Double
        if(pattern[0] == "F" || pattern[0] == "L"){
            newMinNum = minNum
            newMaxNum = halfway - 1
        } else {
            newMinNum = halfway
            newMaxNum = maxNum
        }
        val newPattern = pattern.slice(IntRange(1, pattern.size-1))
            return if(pattern.size==1) {
                return if(pattern[0] == "F" || pattern[0] == "L") minNum else maxNum
            } else {
                return checkSeat(newPattern, newMinNum, newMaxNum)
            }
    }

    fun readFileLineByLineUsingForEachLine(filename: String): List<String> {
        val list = mutableListOf<String>()
        File(filename).forEachLine {
            list.add(it)
        }
        return list
    }
}

