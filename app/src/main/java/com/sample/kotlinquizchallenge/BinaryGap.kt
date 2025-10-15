package com.sample.kotlinquizchallenge

/*
* Find the longest sequence of consecutive zeros in binary representation surrounded by ones.
*
* // Input
* findBinaryGap(9)   // Binary: 1001
* findBinaryGap(529) // Binary: 1000010001
* findBinaryGap(32)  // Binary: 100000
*
* // Expected Output
* 9 → 2
* 529 → 4
* 32 → 0 (no gap surrounded by ones)
* */

fun main() {

    println(longestZeroes(9))
    println(longestZeroes(529))
    println(longestZeroes(32))

}

fun longestZeroes(n: Int): Int{
    val binary = Integer.toBinaryString(n)
    val parts = binary.trim('0').split('1')
    var maxGap = 0

    for (part in parts) {
        if (part.isNotEmpty()) {
            maxGap = maxOf(maxGap, part.length)
        }
    }

    return maxGap
}