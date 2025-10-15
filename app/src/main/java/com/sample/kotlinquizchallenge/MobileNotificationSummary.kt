package com.sample.kotlinquizchallenge

/*
*
* Write a function that takes the number of notifications a user has received and returns a summary string.
*
* Example
* -> 0 -> No Notifications
* -> 1-99 -> You have 3 Notifications
* -> 100+ -> You have Notifications 99+
* */

fun main() {

    println(getNotificationSummary(0))
    println(getNotificationSummary(4))
    println(getNotificationSummary(42))
    println(getNotificationSummary(412))

}

fun getNotificationSummary(count: Int): String {
    return when {
        count == 0 -> "No Notifications"
        count in 1..99 -> "You have $count Notifications"
        else -> "You have Notifications 99+"
    }
}