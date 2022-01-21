package javakotlinpractical

fun main() {
    //Immutable
    var map1 = mapOf <Int,String> (1 to "apple" , 4 to "mango")

    for(key in map1.keys) {
        println("Element at key: $key = ${map1[key]}")
    }
    //mutable
    //we can use HashMap , hashmapof and mutableMapof
    var map = mutableMapOf <Int,String> ()
    map.put(1, "apple")
    map.put(2, "mango")
    map.put(2, "banana")
    for(key in map.keys) {
        println("Element at key: $key = ${map[key]}")
    }
}