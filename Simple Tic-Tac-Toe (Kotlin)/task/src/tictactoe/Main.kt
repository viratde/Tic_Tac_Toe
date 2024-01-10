package tictactoe

fun main() {
    // write your code here


    val stateString = readln()

    val gameState = mutableListOf(
        stateString.slice(0..2).split("").toMutableList(),
        stateString.slice(3..5).split("").toMutableList(),
        stateString.slice(6..8).split("").toMutableList()
    )

    logGameState(gameState = gameState)

}

fun logGameState(
    gameState: MutableList<MutableList<String>>
) {

    println("---------")
    gameState.forEach {
        println(it.joinToString(separator = " ", prefix = "|", postfix = "|"))
    }
    println("---------")

}