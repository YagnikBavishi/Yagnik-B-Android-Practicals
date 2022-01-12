package javakotlinpractical

fun main(){
    //Immutable set
    var set1 = setOf <Int> (2, 5, 6, 7, 30, 6, 7)

    for(element in set1) {
        println(element)
    }
    //mutable set
    //hashsetof the sequence is not matter.
    var set = hashSetOf <Int> (2, 5, 6, 0, 7, 30, 6, 7)
    set.add(10)
    set.remove(30)

    for(element in set) {
        println(element)
    }
}