package com.sample.kotlinquizchallenge

/*
*
* Create a Song class with properties and computed properties.
*
* // Input
* val song = Song("Bohemian Rhapsody", "Queen", 2500000, 354)
*
* // Expected Output
* song.formattedDuration → "05:54"
* song.isPopular() → true
*
* */

fun main() {

    val song = Song("Bohemian Rhapsody", "Queen", 2500000, 354)
    println(song.formattedDuration)
    println(song.isPopular())

}

class Song(
    val title: String,
    val artist: String,
    val playCount: Int,
    val durationInSeconds: Int
) {
    val formattedDuration: String
        get() {
            val minutes = durationInSeconds / 60
            val seconds = durationInSeconds % 60
            return "%02d:%02d".format(minutes, seconds)
        }

    fun isPopular(): Boolean {
        return playCount > 1000000
    }
}