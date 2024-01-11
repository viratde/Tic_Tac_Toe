fun main() {
    // write your code here
    val vowels = listOf('a', 'e', 'i', 'o', 'u', 'y')

    val rand = readln().map {
        vowels.contains(it)
    }

    val counts = mutableListOf<Int>()

    var curChar = rand[0]
    var count = 1
    for (i in 1..rand.lastIndex) {
        if (rand[i] == curChar) {
            count++
        } else {
            if (count > 2) {
                counts.add(count)
                count = 1
                curChar = rand[i]
            }else{
                count = 1
                curChar = rand[i]
            }
        }
        if( i == rand.lastIndex && rand.last() == rand[rand.lastIndex - 1]){
            if (count > 2) {
                counts.add(count)
            }
        }
    }
    if(counts.isEmpty()){
        println(0)
    }else{
        println(counts.sumOf { (it - 1) /2 })
    }
}