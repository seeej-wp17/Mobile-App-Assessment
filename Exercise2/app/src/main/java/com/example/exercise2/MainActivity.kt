package com.example.exercise2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonCalculate.setOnClickListener(){
            getAttributes()
        }

        buttonReset.setOnClickListener(){
            resetAll()
        }

    }

    private fun getAttributes(){
        val weight = editTextWeight.text.toString().toDouble()
        val height = editTextHeight.text.toString().toDouble()/100
        compareBMI(calculateBMI(weight,height))
        textViewBMI.text = String.format("%.2f", calculateBMI(weight, height))

    }
    private fun  calculateBMI(weight:Double, height:Double):Double{
        val bmi : Double = weight/ (height * height)
        return bmi
    }

    private fun compareBMI(bmi : Double){
        if(bmi > 25){
            imageViewProfile.setImageResource(R.drawable.over)
        }
        else if (bmi < 24.9 && bmi > 18.5 ){
            imageViewProfile.setImageResource(R.drawable.normal)
        }
        else if (bmi < 18.5){
            imageViewProfile.setImageResource(R.drawable.under)
        }
        else{
            imageViewProfile.setImageResource(R.drawable.empty)
        }
    }

    private fun resetAll(){
        editTextHeight.text.clear()
        editTextWeight.text.clear()
        imageViewProfile.setImageResource(R.drawable.empty)
        textViewBMI.text = ""
    }

}
