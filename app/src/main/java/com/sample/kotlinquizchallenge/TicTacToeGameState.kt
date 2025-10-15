package com.sample.kotlinquizchallenge

/*
* Model a Tic Tac Toe game with board state and game status.
*
* // Input
* // X _ _
* // O X _
* // O _ X

* // Expected Output
* gameState.status → GameStatus.X_WINS
* gameState.currentPlayer → null (game ended)
* */

fun main() {
    val board = arrayOf(
        charArrayOf('X', '_', '_'),
        charArrayOf('O', 'X', '_'),
        charArrayOf('O', '_', 'X')
    )

    val status = checkWinner(board)
    val currentPlayer = if (status == GameStatus.ONGOING) Player.O else null

    val gameState = GameState(board, currentPlayer, status)

    println("Game Status: ${gameState.status}")
    println("Current Player: ${gameState.currentPlayer}")
}

enum class Player { X, O }
enum class GameStatus { ONGOING, X_WINS, O_WINS, DRAW }

data class GameState(
    val board: Array<CharArray>,
    val currentPlayer: Player?,
    val status: GameStatus
)

fun checkWinner(board: Array<CharArray>): GameStatus {
    val lines = listOf(
        // Rows
        listOf(board[0][0], board[0][1], board[0][2]),
        listOf(board[1][0], board[1][1], board[1][2]),
        listOf(board[2][0], board[2][1], board[2][2]),
        // Columns
        listOf(board[0][0], board[1][0], board[2][0]),
        listOf(board[0][1], board[1][1], board[2][1]),
        listOf(board[0][2], board[1][2], board[2][2]),
        // Diagonals
        listOf(board[0][0], board[1][1], board[2][2]),
        listOf(board[0][2], board[1][1], board[2][0])
    )

    return when {
        lines.any { it.all { c -> c == 'X' } } -> GameStatus.X_WINS
        lines.any { it.all { c -> c == 'O' } } -> GameStatus.O_WINS
        board.all { row -> row.all { it != '_' } } -> GameStatus.DRAW
        else -> GameStatus.ONGOING
    }
}