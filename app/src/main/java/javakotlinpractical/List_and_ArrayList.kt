package javakotlinpractical

fun main() {
    //Immutable list
    var list1 = listOf<String>("apple", "banana")

    for(element in list1) {
        println(element)
    }

    //mutable list
    val list = arrayListOf<String>("apple", "banana", "a", "b", "c")
    list.add("mango")
    list.remove("apple")
    list[0] = "apple"

    for(element in list) {
        println(element)
    }
}

