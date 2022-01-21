package javakotlinpractical

fun main() {
    var student = Student("Yagnik", 10)
    print("my id is : ${student.id}")
}

class Student(name: String) {
    var id: Int = -1
    init {
        println("my name is : $name and id : $id ")
    }
    constructor(n: String, id: Int): this(n) {
        this.id = id
    }
}

