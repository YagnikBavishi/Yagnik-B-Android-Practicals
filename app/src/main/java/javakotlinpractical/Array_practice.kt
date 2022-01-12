package javakotlinpractical

fun main() {
    var array = arrayOf(1, 2, 3)
    for(index in array) {
        println(index)
    }

    val sum: IntArray = intArrayOf(1, 2, 3)
    sum[0] = sum[1] + sum[2]
    println(sum[0])

    val array1 = IntArray(5)
    for(index in array1) {
        println(index)
    }

    val array2 = IntArray(5) { 42 }
    for(index in array2) {
        println(index)
    }

    var myArray = Array<Int>(5) { 0 }
    myArray[0] = 2
    myArray[2] = 6
    println(myArray[2])
    for (element in myArray) {
        println(element)
    }
    for(index in 0..4) {
        println(myArray[index])
    }
}