package javakotlinpractical

fun main() {
    var dog = Dog()
    dog.bread = "labra"
    dog.color = "black"
    dog.bark()
    dog.eat()

    var cat = Cat()
    cat.age = 7
    cat.color = "brown"
    cat.meow()
    cat.eat()

    var obj = Child();
    obj.name();
}

open class Animal {
    var color: String = ""
    fun eat() {
        println("Eat")
    }
}

class Dog : Animal() {
    var bread: String = ""

    fun bark() {
        println("Bark")
    }
}

class Cat : Animal() {
    var age: Int = -1

    fun meow() {
        println("Meow")
    }
}

//override method
open class Parent{
    open fun name() {
        println("parent class")
    }
}

class Child : Parent() {
    override fun name() {
        super.name()
        println("child class")
    }
}
