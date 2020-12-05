//package com.aoc.adventOfCode2020.solutions
//
//import org.springframework.stereotype.Component
//import java.io.File
//import java.lang.Exception
//
//@Component
//class Puzzle7 {
//    init {
//        val prefix = "/Users/sro01/Documents/002_PersonalCode/adventOfCode2020/src/main/kotlin/com/aoc/adventOfCode2020/inputs/"
//        val inputPuzzle = "inputDay4.txt"
//        val rawFile = readFileLineByLineUsingForEachLine("${prefix}${inputPuzzle}")
//
//        val possPassportList = createPossiblePassportList(rawFile)
//        val validPassports = filterForValidPassports(possPassportList)
//        println("HERES YOUR VALID PASSPORTS....")
//        println(validPassports)
//        println(validPassports.size)
//    }
//
//
//    fun createPossiblePassportList(file: List<String>): MutableList<Map<String, Any>> {
//        var list = mutableListOf<Map<String, Any>>()
//        var tempMap = mutableMapOf<String, Any>()
//
//        for ((index, value) in file.withIndex()) {
//            if (value.isBlank() || index == file.size - 1) {
//                list.add(tempMap)
//                tempMap = mutableMapOf<String, Any>()
//            } else {
//                val splitBySpace = file[index].split(" ")
//                val splitByColon = splitBySpace.map { it.split(":")}
//
//                for(entry in splitByColon) {
//                    tempMap[entry[0]] = entry[1]
//                }
//            }
//        }
//        return list
//    }
//
//    fun filterForValidPassports(possPassportList: MutableList<Map<String, Any>>): List<Passport>{
//        val passportList = mutableListOf<Passport>()
//        for(passport in possPassportList) {
//            try {
//                val byr = passport["byr"] as String
//                val iyr = passport["iyr"] as String
//                val eyr = passport["eyr"] as String
//                val hgt = passport["hgt"] as String
//                val hcl = passport["hcl"] as String
//                val ecl = passport["ecl"] as String
//                val pid = passport["pid"] as String
//                passportList.add(Passport(byr, iyr, eyr, hgt, hcl, ecl, pid))
//                println(Passport(byr, iyr, eyr, hgt, hcl, ecl, pid))
//            } catch (e: Exception) {
//                println(e)
//            }
//        }
//        return passportList
//    }
//
//    fun readFileLineByLineUsingForEachLine(filename: String): List<String> {
//        val list = mutableListOf<String>()
//        File(filename).forEachLine {
//            list.add(it)
//        }
//        return list
//    }
//}
//
//data class Passport(val byr: String, val iyr: String, val eyr: String, val hgt: String, val hcl: String, val ecl: String, val pid: String, val cid: String? = null)
