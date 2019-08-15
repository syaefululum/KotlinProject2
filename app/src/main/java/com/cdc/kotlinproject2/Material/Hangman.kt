package com.cdc.kotlinproject2.Material

fun main(args: Array<String>){
    print("Enter the word to guess:")
    val word = readLine()
    if(word == null){
        println("No word given, game ended")
        return
    }

    val letters = word.toLowerCase().toCharArray().toHashSet()
    val correctGuesses = mutableSetOf<Char>()
    var live: Int = 3
    var fails = 0

    while (letters != correctGuesses) {
        printExploreWord(word, correctGuesses)
        println("#Wrong guesses: $fails")

        print("Guess letter: ")
        val input = readLine()

        if(input == null){
            continue
        }else if (input.length != 1){
            println("Please input one letter!")
            continue
        }

        if (word.toLowerCase().contains(input.toLowerCase())){
            correctGuesses.add(input[0].toLowerCase())
        } else {
            ++fails
            --live
        }
    }

    println("Well Done")
    println("The word is $word")
    println("Wrong guessess $fails")
}

fun printExploreWord(word: String, correctGuessess: Set<Char>){
    val letters = word.toLowerCase()
    for (letter in letters){
        if(correctGuessess.contains(letter)){
            print(letter + " ")
        }else{
            print("_ ")
        }
    }
}