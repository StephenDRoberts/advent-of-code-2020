//package com.aoc.adventOfCode2020.solutions
//
//import org.springframework.stereotype.Component
//import java.io.File
//import java.lang.Exception
//
//@Component
//class Puzzle8 {
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
//                val byr = passport["byr"].toString().toInt()
//                val byrValidity = checkBYRValidity((byr))
//
//                val iyr = passport["iyr"].toString().toInt()
//                val iyrValidity = checkIYRValidity((iyr))
//
//                val eyr = passport["eyr"].toString().toInt()
//                val eyrValidity = checkEYRValidity((eyr))
//
//                val hgt = passport["hgt"] as String
//                val hgtValidity = checkHGTValidity((hgt))
//
//                val hcl = passport["hcl"] as String
//                val hclValidity = checkHCLValidity(hcl)
//
//                val ecl = passport["ecl"] as String
//                val eclValidity = checkECLValidity(ecl)
//
//                val pid = passport["pid"] as String
//                val pidValidity = checkPIDValidity(pid)
//
//                if(byrValidity && iyrValidity && eyrValidity && hgtValidity && hclValidity && eclValidity && pidValidity) {
//                    passportList.add(Passport(byr, iyr, eyr, hgt, hcl, ecl, pid))
//                }
//            } catch (e: Exception) {}
//        }
//        return passportList
//    }
//
//    fun checkBYRValidity(value: Int): Boolean {
//        return value in 1920..2002
//    }
//
//    fun checkIYRValidity(value: Int): Boolean {
//        return value in 2010..2020
//    }
//
//    fun checkEYRValidity(value: Int): Boolean {
//        return value in 2020..2030
//    }
//    fun checkHGTValidity(value: String): Boolean {
//        return when {
//            value.contains("in") -> {
//                val formattedIN = value.replace("in","").toInt()
//                formattedIN in 59..76
//            }
//            value.contains("cm")-> {
//                val formattedCM = value.replace("cm","").toInt()
//                formattedCM in 150..193
//            }
//            else -> {
//                false
//            }
//        }
//    }
//
//    fun checkHCLValidity(value: String): Boolean {
//        val regex = "^#[a-f0-9]{0,6}$".toRegex()
//        return regex.containsMatchIn(value)
//    }
//
//    fun checkECLValidity(value: String): Boolean {
//        val regex = "^(amb|blu|brn|gry|grn|hzl|oth)$".toRegex()
//        return regex.containsMatchIn(value)
//    }
//
//    fun checkPIDValidity(value: String): Boolean {
//        val regex = "^[0-9]{9}$".toRegex()
//        return regex.containsMatchIn(value)
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
//data class Passport(val byr: Int, val iyr: Int, val eyr: Int, val hgt: String, val hcl: String, val ecl: String, val pid: String, val cid: String? = null)
