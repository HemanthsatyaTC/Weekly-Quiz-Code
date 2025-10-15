package com.sample.kotlinquizchallenge

/*
*
* Implement an auction bidding system where new bids must be higher than current bid.
*
* // Input
* placeBid(50)  // First bid
* placeBid(30)  // Too low
* placeBid(75)  // Valid higher bid
*
* // Expected Output
* 50 → 50 (accepted)
* 30 → null (rejected)
* 75 → 75 (accepted)
* */

fun main() {
    println(placeBid(50))
    println(placeBid(30))
    println(placeBid(75))

}


var currentBid: Int? = null

fun placeBid(bid: Int): Int? {
    return if (currentBid == null || bid > currentBid!!) {
        currentBid = bid
        currentBid
    } else {
        null
    }
}