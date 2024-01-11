fun main() {
    // put your code here

    val a = readln()

    println("${a.last()}${a.slice(1 until a.lastIndex)}${a.first()}")
}