package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){
            calculateAll()
        }

        buttonReset.setOnClickListener(){
            resetAll()
        }

    }

    private fun calculateAll(){
        val carprice = editTextCarPrice.text.toString().toInt()
        val downpayment = editTextDownPayment.text.toString().toInt()
        val peroid = editTextLoanPeriod.text.toString().toInt()
        val interestrate = editTextInterestRate.text.toString().toInt()
        val loan = carprice - downpayment
        val interest = loan * interestrate * peroid
        val monthlyrepayment = (loan + interest)/peroid/12

        textCarLoan.text = loan.toString()
        textInterest.text = interest.toString()
        textMonthlyRepayment.text = monthlyrepayment.toString()
    }

    public fun resetAll(){
        textMonthlyRepayment.text = ""
        textInterest.text = ""
        textCarLoan.text = ""
        editTextInterestRate.text.clear()
        editTextLoanPeriod.text.clear()
        editTextDownPayment.text.clear()
        editTextCarPrice.text.clear()
    }

}
