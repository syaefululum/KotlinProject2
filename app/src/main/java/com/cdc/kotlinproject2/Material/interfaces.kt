package com.cdc.kotlinproject2.Material

class House(val height: Double, val color: String, val price: Int = 10000){
    fun print(){
        println("House [height: $height, color: $color, price: $price]")
    }
}

abstract class Person(open val name: String, open var age: Int){
    abstract fun speak()

    fun greet() {
        println("Hello $name!")
    }
}

class Student(override val name: String, override var age: Int, val studentID: Long): Person(name, age){
    override fun speak() {
        println("Hai my student name is $name")
    }
}

class Employee(override val name: String, override var age: Int): Person(name, age){
    override fun speak() {
        println("Hai my employee name is $name")
    }
}

interface  Driveable {
    fun drive()
}

interface  Buildable {
    val timeRequired: Int
    fun build()
}

class Car(val color: String): Driveable, Buildable {
    override val timeRequired = 120

    override fun build() {
        println("Driving Car..")
    }

    override fun drive() {
        println("Built a shiny car")
    }
}

class Motorcycle(val color: String): Driveable {
    override fun drive() {
        println("Driving motorcycle")
    }
}

fun main(args: Array<String>){
    val house = House(height = 1.4, color = "White", price = 1350000)
    val redHouse = House(height = 100.1, color = "Red")
    val student = Student("maria", 17, 10000001)
    val employee = Employee("Maman", 40)
    student.speak()
    employee.speak()

    //interfaces
    val car: Driveable = Car("blue")
    car.drive()
    val motorcycle: Driveable = Motorcycle("red")
    motorcycle.drive()

    //redHouse.print()
}