package javakotlinpractical

fun main() {
    val items = listOf("a", "b", "c")
    for (index in items) {
        println(index)
    }
    for (index in items.indices) {
        println(index)
    }
    val startingIndex = 10
    if (startingIndex in 1..8) {
        println("fits in range")
    }
    for (index in 1..10) {
        print(index)
    }
    println()
    for (index in 1..10 step 2) {
        print(index)
    }
    println()
    for (index in 9 downTo 0 step 3) {
        print(index)
    }
}