package com.mnazari2.wordleapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import com.mnazari2.wordleapp.FourLetterWordList.FourLetterWordList.getRandomFourLetterWord

class MainActivity : AppCompatActivity() {

    val wordToGuess = getRandomFourLetterWord()
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //Creating vals that reference the text views
        val EditText = findViewById<View>(R.id.et_simple) as EditText
        val ans = findViewById<TextView>(R.id.textView)
        val guess_1 = findViewById<TextView>(R.id.guess_1)
        val guess_2 = findViewById<TextView>(R.id.guess_2)
        val guess_3 = findViewById<TextView>(R.id.guess_3)

        val guess_1c = findViewById<TextView>(R.id.guess_check_1)
        val guess_2c = findViewById<TextView>(R.id.guess_check_2)
        val guess_3c = findViewById<TextView>(R.id.guess_check_3)

        val guessOneView = findViewById<TextView>(R.id.user_guess_1)
        val Checked_guessOneView = findViewById<TextView>(R.id.user_checked_guess1)
        val guessTwoView = findViewById<TextView>(R.id.user_guess_2)
        val Checked_guessTwoView = findViewById<TextView>(R.id.user_checked_guess2)

        val guessThreeView = findViewById<TextView>(R.id.user_guess_3)
        val Checked_guessThreeView = findViewById<TextView>(R.id.user_checked_guess3)

        //Making textViews non visible to the user
        ans.text = wordToGuess
        ans.isVisible = false
        guess_1.isVisible = false
        guess_2.isVisible = false
        guess_3.isVisible = false

        guess_1c.isVisible = false
        guess_2c.isVisible = false
        guess_3c.isVisible = false

        val button = findViewById<Button>(R.id.button)


        button.setOnClickListener{
            val str = EditText.text.toString()

            if(counter == 0){

                   guess_1.isVisible = true
                   guessOneView.text =  str
                   guess_1c.isVisible = true
                   Checked_guessOneView.text = checkGuess(str.uppercase())
                   EditText.text.clear()
                   counter++


             }else if(counter == 1){

                 guess_2.isVisible = true
                 guessTwoView.text =  str
                 guess_2c.isVisible = true
                 Checked_guessTwoView.text = checkGuess(str.uppercase())
                 EditText.text.clear()
                 counter++


             }else if(counter == 2){
                guess_3.isVisible = true
                guessThreeView.text =  str
                guess_3c.isVisible = true
                Checked_guessThreeView.text = checkGuess(str.uppercase())
                ans.isVisible = true
                button.isEnabled = false
                button.setBackgroundColor(Color.GRAY)

            }

        }



    }
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}