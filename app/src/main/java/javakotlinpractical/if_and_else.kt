package javakotlinpractical
import java.util.Scanner
fun main() {
    var scanner =  Scanner(System.`in`)
    val number1 = scanner.nextInt()
    val number2 = scanner.nextInt()
    val max = if (number1 > number2) {
        println("number1 is large")
        number1
    } else {
        println("number2 is large")
        number2
    }
    println("maximum value: $max")
    println("Enter operator either +, -, * or /")
    val operator = readLine()
    val result = when (operator) {
        "+" -> number1 + number2
        "-" -> number1 - number2
        "*" -> number1 * number2
        "/" -> number1 / number2
        else -> "$operator operator is invalid operator."
    }
    println(result)
}