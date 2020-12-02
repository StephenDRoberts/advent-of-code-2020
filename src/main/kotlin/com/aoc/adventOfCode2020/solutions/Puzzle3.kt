package com.aoc.adventOfCode2020.solutions

import org.springframework.stereotype.Component
import java.io.File
import kotlin.reflect.typeOf

@Component
class Puzzle3 {

//    fun findSolution(inputPuzzle: String) {
init {


    val prefix = "/Users/sro01/Documents/002_PersonalCode/adventOfCode2020/src/main/kotlin/com/aoc/adventOfCode2020/inputs/"
    val inputPuzzle = "input3.txt"
    val filepath = "${prefix}${inputPuzzle}"

    val inputArray = readFileLineToPasswordType(filepath)

    val finalArray = inputArray.filter { it -> checkPassword(it) }
    println(finalArray.size)
    }

    fun checkPassword(obj: PasswordObject): Boolean {
        val count = obj.password.chunked(1).count { it == obj.character }
        return count >= obj.minNum && count <= obj.maxNum
    }

    fun readFileLineToPasswordType(fileName: String): List<PasswordObject> {
        val list = mutableListOf<PasswordObject>()
        File(fileName).forEachLine { it ->
            val splitToSections = it.split(" ")
            val firstSection = splitToSections[0].split("-").filter { it != "-" }

            val minNum = firstSection[0].toInt()
            val maxNum = firstSection[1].toInt()

            val character = splitToSections[1].chunked(1).filter { it != ":" }[0]

            val password = splitToSections[2]

            val obj = PasswordObject(minNum, maxNum, character, password)

            list.add(obj) }
        return list
    }
}

data class PasswordObject(val minNum: Int, val maxNum: Int, val character: String, val password: String)