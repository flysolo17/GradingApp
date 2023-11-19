package com.ketchupzz.gradingapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var  edtScience : EditText
    private lateinit var  edtMath : EditText
    private lateinit var  edtFilipino : EditText
    private lateinit var  edtEnglish : EditText
    private lateinit var textAverage : TextView
    private lateinit var imageAverage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtScience = findViewById(R.id.edtScience)
        edtMath = findViewById(R.id.edtMath)
        edtFilipino = findViewById(R.id.edtFilipino)
        edtEnglish = findViewById(R.id.edtEnglish)
        textAverage = findViewById(R.id.textAverage)
        imageAverage = findViewById(R.id.imageAverage)
        findViewById<Button>(R.id.buttonComputeAvg).setOnClickListener {
            val num1 =  edtScience.text.toString()
            val num2 = edtMath.text.toString()
            val num3 = edtFilipino.text.toString()
            val num4 = edtEnglish.text.toString()
            val average = computeAverage(convertToFloat(num1),convertToFloat(num2),convertToFloat(num3),convertToFloat(num4))
            textAverage.text = "Average: ${String.format("%.2f", average)}"
            imageAverage.setImageResource(displayImage(average))
        }
    }

    //this function compute the average of 3 float numbers
    private fun computeAverage(num1 : Float, num2 : Float, num3 : Float,num4 : Float) : Float {
        return (num1 + num2 + num3 + num4) / 4
    }

    // convert the user input into float
    private fun convertToFloat(num: String): Float {
        if (num.isEmpty()) {
            return 0f
        }
        return num.toFloat()
    }
    // this function determines what image to display
    private fun displayImage(avg : Float) : Int {
        if (avg < 75) {
            return R.drawable.sad
        }
        return R.drawable.happy
    }

}