package javakotlinpractical

val pi: Float by lazy {
    3.14f
}

fun main() {
    println("Hello world!!!")
    val one: Int = 1
    val two = 2
    val three: Int = 3
    println(one)
    println(two)
    println(three)

    val str = "abcd"

    for (index in str) {
        println(index)
    }

    val string = "abc" + 1
    println(string + "def")

    val area1 = pi * 2 * 2
    val area2 = pi * 8 * 8
    println(area1)
    println(area2)
}
