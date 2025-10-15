package com.sample.kotlinquizchallenge

/*
* Find the most frequently occurring word, ignoring common stop words.
*
* // Input
* findMostCommonWord("The sun shines and the sky is blue and clear")
*
* // Expected Output
* "The sun shines and the sky is blue and clear" → "and"
*
* */

fun main() {
    val sentence = "The sun shines and the sky is blue and clear"
    println(findMostCommonWord(sentence))

}

fun findMostCommonWord(text: String): String {
    val words = text
        .lowercase()
        .split(Regex("\\W+"))
        .filter { it.isNotBlank() }

    if (words.isEmpty()) return "No valid words"

    val frequency = words.groupingBy { it }.eachCount()
    return frequency.maxByOrNull { it.value }?.key ?: "No valid words"
}