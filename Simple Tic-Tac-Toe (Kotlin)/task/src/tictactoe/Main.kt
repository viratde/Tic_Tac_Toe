package tictactoe

import java.lang.NumberFormatException
import kotlin.math.abs

fun main() {
    // write your code here


    val stateString = "         "

    val gameState = mutableListOf(
        stateString.slice(0..2).toMutableList(),
        stateString.slice(3..5).toMutableList(),
        stateString.slice(6..8).toMutableList()
    )

    logGameState(gameState = gameState)
    var player = 'X'

    while (true) {
        try {
            val playGame = readln().split(" ").filter {
                it.isNotEmpty()
            }.map { it.toInt() }

            if (playGame.find { it < 1 || it > 3 } != null) {
                println("You should enter numbers!")
            } else if (gameState[playGame[0] - 1][playGame[1] - 1] == 'X' || gameState[playGame[0] - 1][playGame[1] - 1] == 'O') {
                println("This cell is occupied! Choose another one!")
            } else {
                gameState[playGame[0] - 1][playGame[1] - 1] = player
                player = if (player == 'X') 'O' else 'X'
                logGameState(gameState = gameState)
                val gameStatus = findGameStatus(gameState)
                if (gameStatus == "Draw") {
                    println(gameStatus)
                    break
                } else if (gameStatus.indexOf("wins") != -1) {
                    println(gameStatus)
                    break
                }
            }

        } catch (e: NumberFormatException) {
            println("You should enter numbers!")
        }
    }


}

fun logGameState(
    gameState: MutableList<MutableList<Char>>
) {

    println("---------")
    gameState.forEach {
        println(it.joinToString(separator = " ", prefix = "| ", postfix = " |"))
    }
    println("---------")

//    println(findGameStatus(gameState))
}

fun findGameStatus(
    gameState: MutableList<MutableList<Char>>
): String {

    val xChars = gameState.flatten().count {
        it == 'X'
    }
    val oChars = gameState.flatten().count {
        it == 'O'
    }
    val empty = gameState.flatten().count {
        it != 'X' && it != 'O'
    }
    if (abs(xChars - oChars) > 1) {
        return "Impossible"
    }

    val xWins = findWinStatus(gameState, 'X')
    val oWins = findWinStatus(gameState, 'O')

    return if (xWins == 0 && oWins == 0 && empty != 0) {
        "Game not finished"
    } else if (xWins == 0 && oWins == 0) {
        "Draw"
    } else if (xWins > 1 || oWins > 1) {
        "Impossible"
    } else if (xWins == 1 && oWins == 1) {
        "Impossible"
    } else if (xWins == 1) {
        "X wins"
    } else {
        "O wins"
    }

}

fun findWinStatus(
    gameState: MutableList<MutableList<Char>>,
    winnerFlag: Char
): Int {

    var wins = 0

    for (i in 0..2) {
        if (
            gameState[i][0] == gameState[i][1] &&
            gameState[i][1] == gameState[i][2] &&
            gameState[i][2] == winnerFlag
        ) {
            wins++
        }
    }

    for (i in 0..2) {
        if (
            gameState[0][i] == gameState[1][i] &&
            gameState[1][i] == gameState[2][i] &&
            gameState[2][i] == winnerFlag
        ) {
            wins++
        }
    }

    if (
        gameState[0][0] == gameState[1][1] &&
        gameState[1][1] == gameState[2][2] &&
        gameState[2][2] == winnerFlag
    ) {
        wins++
    }

    if (
        gameState[0][2] == gameState[1][1] &&
        gameState[1][1] == gameState[2][0] &&
        gameState[2][0] == winnerFlag
    ) {
        wins++
    }

    return wins

}