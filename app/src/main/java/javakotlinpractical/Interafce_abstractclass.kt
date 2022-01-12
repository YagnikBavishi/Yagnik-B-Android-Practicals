package javakotlinpractical

fun main() {
    var button = Button()
    button.touch()
    button.click()
    button.method1()
}

abstract  class abstractclass {
    abstract fun method1()
}

interface MyFirstInterface {
    fun touch()
    fun click() {
        println("click : MyFirstInterface")
    }
}

interface MySecondInterface {
    fun touch() {
        println("touch : MySecondInterface")
    }
    fun click() {
        println("click : MySecondInterface")
    }
}

class Button : MyFirstInterface, MySecondInterface, abstractclass() {
    override fun touch() {
        super<MySecondInterface>.touch()
        println("class touch method")
    }

    override fun click() {
        super<MyFirstInterface>.click()
        super<MySecondInterface>.click()
    }

    override fun method1() {
        println("abstract method")
    }
}