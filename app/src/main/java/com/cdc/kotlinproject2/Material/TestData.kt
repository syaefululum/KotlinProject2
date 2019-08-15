package com.cdc.kotlinproject2.Material

//class
class Book(val title: String, val author: String, val publicationYear: Int, var borrowed: Boolean) {
    fun print(){
        println("Title: $title, Author: $author, Publication Year: $publicationYear")
    }

    fun borrow(): Boolean{
        if(borrowed){
            println("The book is already borrowed")
            return false
        } else {
            borrowed = true
            return true
        }
    }

    fun returnBook(): Boolean {
        if (!borrowed){
            println("The book was not borrowed, it cannot be returned")
            return false
        } else {
            borrowed = false
            return true
        }
    }

}

class Person1(val name: String, var age: Int) {

    //method
    fun speak(){
        println("Hello!")
    }

    fun greet(name: String){
        println("Hello $name")
    }

    fun getYearOfBirth() = 2019 - age
}

class House1(val height: Double, val color: String, val price: Int = 50000){
    fun print(){
        println("House [height:$height, color:$color, price:$price]")
    }
}

fun main(args: Array<String>) {
    val person = Person1("jasmin", 23)
    println(person.name)
    println(person.age)
    person.speak()
    person.getYearOfBirth()

    val book = Book("Key of success adalah kunci kemenangan", "Sidu", 1997, false)
    book.borrow()
    book.returnBook()
    book.print()

    val age: Int = 15

    // if condition
    if (age < 18) {
        println("You cannot register")
    } else {
        println("you're good to go")
    }

    //when condition
    when (age) {
        11 -> println("you're is eleven")
        12 -> {
            println("the age is twelve")
            println("you're is old")
        }
        15 -> println("you're is lima belas deh")
        else -> println("the age not found")
    }


    //array
    val array = arrayOf("Bandung", "Jakarta", "Bekasi")
    val mixed = arrayOf("Kotlin", 1, 1.2, true)
    val numbers = intArrayOf(1,2,3,4)
    println(mixed[0])
    mixed[2] = 3.43040
    println(mixed[2])

    val array2 = arrayOf("Garut", "Palembang", "Makasar")
    val allStates = array + array2

    println(allStates.size)
    val empty: Boolean = numbers.isEmpty()

    if(array.contains("Bandung")){
        println("It contains Bandung")
    } else {
        println("It does not")
    }
     //list
    val list = listOf("Orange", "Apple", "Bananas")
    val arrayList = arrayListOf("Maman", "Endang", "adiknya pak endang")
    arrayList.add("amanda")

    val changed = arrayList.add(1, "Celamet")
    val removed = arrayList.remove("Endang")
    val sublist = arrayList.subList(1,4)

    //looping for
    var sum = 0
    for (i in 1..100) {
        sum = sum + i
    }

    println(sum)
    val listOfProggraming = listOf("Java", "Kotlin", "Phyton")
    for (element in listOfProggraming) {
        println(element)
    }

    for ((index, value) in listOfProggraming.withIndex()) {
        println("Element at $index is $value")
    }

    //looping while
    var x = 9
    while (x >= 9) {
        println(x)
        x--
    }

    var i = 1
    while (i <= 10) {
        println(i)
        i++
    }

    for (c in "phython"){
        if (c == 'o') {
            break
        }
        print(c)
    }

    for (str in listOfProggraming) {
        if (!str.contains('o')){
            continue
        }
        print(str)
    }

    //loop naming
    outer@ for (i in 1..10) {
        for (j in 1..10) {
            if (i-j == 5) {
                break@outer
            }
            println("$i - $j")
        }
    }
}
