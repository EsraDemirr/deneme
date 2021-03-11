package com.example.zarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    //Değişkenlerimizi global yani her yerden erişilebilir şeklinde tanımlayalım:
    lateinit var diceText   : TextView
    lateinit var diceButton : Button
    lateinit var diceImage  : ImageView
    lateinit var getData    : EditText
    lateinit var getButton  : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceText     = findViewById(R.id.diceText)
        diceButton   = findViewById(R.id.diceButton)
        diceImage    = findViewById(R.id.diceImage)
        getData      = findViewById(R.id.getData)
        getButton    = findViewById(R.id.getButton)

        diceButton.setOnClickListener{
            changeText()
        }
        getButton.setOnClickListener{
            sendText()
        }
    }

    private fun sendText() {
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("send",getData.text.toString())
        startActivity(intent)
    }

    private fun changeText() {
        val randomNumber = (1..6).random()
        val drawableResource = when(randomNumber){
            1-> R.drawable.dice1
            2-> R.drawable.dice2
            3-> R.drawable.dice3
            4-> R.drawable.dice4
            5-> R.drawable.dice5
            else-> R.drawable.dice6
        }
        diceImage.setImageResource(drawableResource)
        diceText.text = randomNumber.toString()
       Toast.makeText(this,"Number: ${diceText.text}",Toast.LENGTH_SHORT).show()
    }



}