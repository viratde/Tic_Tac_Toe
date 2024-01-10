package tictactoe

fun main() {
    // write your code here

    val gameState = mutableListOf(
        mutableListOf("X", "X", "O"),
        mutableListOf("X", "O", "X"),
        mutableListOf("X", "O", "X")
    )
    logGameState(gameState)
}

fun logGameState(
    gameState: MutableList<MutableList<String>>
) {

    gameState.forEach {
        println(it.joinToString(separator = " "))
    }

}