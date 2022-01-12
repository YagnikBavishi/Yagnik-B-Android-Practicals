package javakotlinpractical

fun sum (value1 : Int, value2 : Int): Int {
    return value1 + value2
}

//Using Unit :-
fun sumUnit (value1 : Int, value2 : Int): Unit {
    println("$value1 and $value2 sum = ${value1 + value2}")
}

//Using Extension Function
fun main() {
    println(sum(10, 20))
    sumUnit(10, 20)
    val string1: String = "Hello "
    val string2: String = "World "
    val string3: String = "Hey "
    println(string3.add(string1, string2))
}

fun String.add(str1: String, str2:String): String {
    return this + str1 + str2
}

