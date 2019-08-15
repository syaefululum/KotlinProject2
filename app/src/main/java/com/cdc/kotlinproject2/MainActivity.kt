package com.cdc.kotlinproject2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    open var word: String = ""
    open var correctGuessess = mutableSetOf<Char>()
    open var fails: Int = 0
    open var live: Int = 0
    open var arrayLive = arrayListOf("head", "arm1", "arm2", "body", "leg1", "leg2")
    open var arrayFails = mutableSetOf<Char>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initial
        this.reset()
        btnPlay.visibility = View.INVISIBLE
        //println("word: $word, correctGuesses: $correctGuessess, fails: $fails, live: $live")

        tvResult.text = this.printExploreWord(word.toLowerCase(), correctGuessess)
        btnCheck.setOnClickListener {
            if (live <= 0 ){
                tvErrorMessage.text = "You lose, Total fails: $fails"
                btnPlay.visibility = View.VISIBLE
                btnCheck.visibility = View.INVISIBLE
            } else {
                if (etGuessesChar.text == null) {
                    tvErrorMessage.text = "Please Input One Letter"
                } else if (etGuessesChar.text.length != 1) {
                    tvErrorMessage.text = "Please Input One Letter"
                } else {
                    if (word.toLowerCase().contains(etGuessesChar.text.toString().toLowerCase())) {
                        correctGuessess.add(etGuessesChar.text[0].toLowerCase())
                        tvResult.text = this.printExploreWord(word.toLowerCase(), correctGuessess)
                        etGuessesChar.text = null
                    } else {
                        fails++
                        live--
                        var image = arrayLive.random()
                        when (image){
                            "head" -> head.visibility = View.VISIBLE
                            "arm1" -> arm1.visibility = View.VISIBLE
                            "arm2" -> arm2.visibility = View.VISIBLE
                            "body" -> body.visibility = View.VISIBLE
                            "leg1" -> leg1.visibility = View.VISIBLE
                            "leg2" -> leg2.visibility = View.VISIBLE
                        }
                        arrayLive.remove(image)
                        tvErrorMessage.text = "Total Fails: $fails"
                    }
                }

                if (word.toLowerCase().toHashSet() == correctGuessess) {
                    tvErrorMessage.text = "Binggo, you won. The word is $word \n Total Fails: $fails"
                    btnPlay.visibility = View.VISIBLE
                }
            }
        }

        btnPlay.setOnClickListener {
            this.reset()
        }
    }

    fun reset(){
        this.fails = 0
        this.word = "Jawabannya"
        this.correctGuessess =  mutableSetOf<Char>()
        this.live = 6

        tvErrorMessage.text = ""
        tvResult.text = this.printExploreWord(this.word.toLowerCase(), this.correctGuessess)
        btnPlay.visibility = View.INVISIBLE
        btnCheck.visibility = View.VISIBLE

        head.visibility = View.INVISIBLE
        arm1.visibility = View.INVISIBLE
        arm2.visibility = View.INVISIBLE
        body.visibility = View.INVISIBLE
        leg1.visibility = View.INVISIBLE
        leg2.visibility = View.INVISIBLE
    }

    fun printExploreWord(word: String, correctGuessess: Set<Char>): String{
        var result: String = ""
        val letters = word.toLowerCase()
        for (letter in letters){
            if(correctGuessess.contains(letter)){
                result += (letter + " ")
            }else{
                result += ("_ ")
            }
        }
        return result
    }
}
