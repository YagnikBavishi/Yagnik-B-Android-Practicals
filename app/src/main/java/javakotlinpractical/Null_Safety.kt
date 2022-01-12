package javakotlinpractical

fun main() {
    var name : String? = null
    println("The length of string ${name?.length}")
    name?.let {
        println("The length of string ${name.length}")
    }
    val length = name?.length ?: -1
    println("The length of string $length")
    println("The length of string ${name!!.length}")
}