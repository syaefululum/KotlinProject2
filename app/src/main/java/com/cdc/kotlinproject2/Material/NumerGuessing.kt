package com.cdc.kotlinproject2.Material

import java.util.*

fun main(args: Array<String>){
    val number = Random().nextInt(100) + 1
    var input: String?
    var guess = -1

    while (guess != number){
        println("Guess a number between 1 and 100: ")
        input = readLine()

        if(input != null){
            guess = input.toInt()
        }

        if(guess < number){
            println("Guess to low")
        } else if (guess > number){
            println("Guess to large")
        } else{
            println("You won")
        }
    }
}