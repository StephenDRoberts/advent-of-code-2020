package com.aoc.adventOfCode2020.solutions

import org.springframework.stereotype.Component
import java.io.File

@Component
class Puzzle7 {
    init {
        val prefix = "/Users/sro01/Documents/002_PersonalCode/adventOfCode2020/src/main/kotlin/com/aoc/adventOfCode2020/inputs/"
        val inputPuzzle = "inputDay4.txt"
        val rawFile = readFileLineByLineUsingForEachLine("${prefix}${inputPuzzle}")
        println(rawFile)

        var list = mutableListOf<Map<String, Any>>()
        val tempMap = mutableMapOf<String, Any>()

    for((index, value) in rawFile.withIndex()){
        if(value.isBlank() || index == rawFile.size-1){
            println("HELLO")
            list.add(tempMap)
            println("LIST $list")
            tempMap.clear()
        } else {
            val split = rawFile[index].split(":")
            println("SPLIT $split")
            tempMap[split[0]] = split[1]
            println("TEMP $tempMap")
        }
    }
println("LIST $list")
    }
//
//    fun addToList(map: Map<String, Any>, list: MutableList<Map<String, Any>>): MutableList<Map<String, Any>> {
////        list.add(map)
//        list.add(list.size,map)
//        return list
//    }

    fun readFileLineByLineUsingForEachLine(filename: String): List<String>{
        val list = mutableListOf<String>()
        File(filename).forEachLine {
            list.add(it)
        }
        return list
    }

    fun checkEndOfPassportEntry(entry: String): Boolean {
        return entry.isBlank()
    }

//    fun readFileLineByLineUsingForEachLine(fileName: String) {
//        var list = mutableListOf<Map<String, Any>>()
//        var tempMap= mutableMapOf<String, Any>()
////        var list = emptyList<Map<String, Any>>()
//
//
//
//        File(fileName).forEachLine { it ->
//            if (it.isBlank()) {
//                println("BLANK LINE")
//                list.add(tempMap)
//                println("NEW LIST $list")
//                tempMap.clear()
//                println("EMPTYING MAP")
//                println(tempMap)
//            } else {
//                println("GOT AN ENTRY")
//                println(it)
//                var splitEntry = it.split(" ")
//                println("SPLIT $splitEntry")
//                for (entry in splitEntry){
//                    println("Entry $entry")
//                    val splitByColon = entry.split(":")
//                    println("COLON $splitByColon")
//                    tempMap[splitByColon[0]] = splitByColon[1]
//                }
//                println("NEW MAP $tempMap")
//                println("WAITING LIST $list")
//            }
////            list.add(tempMap)
//        }
//
////        return list
//    }
}

data class Passport(val byr: Int, val iyr: Int, val eyr: Int, val hgt: String, val hcl: String, val ecl: String, val pid: Int, val cid: Int?)
