package com.example.dice

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollbutton:Button=findViewById(R.id.Button)
        rollbutton.setOnClickListener{rolldice()}
        rolldice()
    }

    private fun rolldice() {
        val dice=Dice(6)
        val image: ImageView =findViewById(R.id.imageview)
        val stext:TextView=findViewById(R.id.textview)
        val result=dice.roll()
        when(result){
            1->image.setImageResource(R.drawable.dice_1)
            2->image.setImageResource(R.drawable.dice_2)
            3->image.setImageResource(R.drawable.dice_3)
            4->image.setImageResource(R.drawable.dice_4)
            5->image.setImageResource(R.drawable.dice_5)
            else->image.setImageResource(R.drawable.dice_6)
        }
        stext.text=result.toString()
    }
}
class Dice(private val sides:Int){
    fun roll():Int{
        return (1..sides).random()
    }
}