package com.gabriel.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnNumberEvent(view: View) {
        if (newOperation == true) {
            txtViewShowNumber.setText("")
        }
        newOperation = false

        val btnSelected = view as Button
        var clickedValue: String = txtViewShowNumber.text.toString()
        when (btnSelected.id) {
            btnZero.id -> {
                if (clickedValue == "0") {
                    txtViewShowNumber.setText("")
                    clickedValue = txtViewShowNumber.text.toString()
                }
                clickedValue += btnZero.text.toString()
            }
            btnOne.id -> {
                if (clickedValue == "0") {
                    txtViewShowNumber.setText("")
                    clickedValue = txtViewShowNumber.text.toString()
                }
                clickedValue += btnOne.text.toString()
            }
            btnTwo.id -> clickedValue += btnTwo.text.toString()
            btnThree.id -> clickedValue += btnThree.text.toString()
            btnFour.id -> clickedValue += btnFour.text.toString()
            btnFive.id -> clickedValue += btnFive.text.toString()
            btnSix.id -> clickedValue += btnSix.text.toString()
            btnSeven.id -> clickedValue += btnSeven.text.toString()
            btnEight.id -> clickedValue += btnEight.text.toString()
            btnNine.id -> clickedValue += btnNine.text.toString()
            btnDot.id -> {
                //TODO: Prevent adding more than one dot
                clickedValue += btnDot.text.toString()
            }
            btnPlusMinus.id -> {

                clickedValue = "-" + clickedValue
            }
        }
        txtViewShowNumber.setText(clickedValue)
    }

    var operation = "*"
    var oldNumber = ""
    var newOperation = true
    fun btnOperationEvent(view: View) {
        val btnSelected = view as Button
        var clickedValue: String = txtViewShowNumber.text.toString()

        when (btnSelected.id) {
            btnMultiply.id -> {
                operation = "*"
                clickedValue = txtViewShowNumber.text.toString() + operation
            }
            btnDivide.id -> {
                clickedValue += txtViewShowNumber.text.toString()
                operation = "/"
            }
            btnSubtract.id -> {
                clickedValue += txtViewShowNumber.text.toString()
                operation = "-"
            }
            btnPlus.id -> {
                clickedValue += txtViewShowNumber.text.toString()
                operation = "+"
            }
        }

        oldNumber = txtViewShowNumber.text.toString()
        newOperation = true
    }

    fun ifZero(){

    }

    fun btnEqualsEvent(view: View) {
        val newNumber = txtViewShowNumber.text.toString()
        var result: Double ?= null
        when(operation){
            "*" -> {
                result = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" ->{
                result = oldNumber.toDouble() / newNumber.toDouble()
            }
            "-" -> {
                result = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                result = oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        txtViewShowNumber.setText(result.toString())
        newOperation = true

    }

    fun btnPercentEvent(view: View) {
        val number = txtViewShowNumber.text.toString().toDouble()/100
        txtViewShowNumber.setText(number.toString())
        newOperation = true
    }

    fun btnClearEvent(view: View) {
        txtViewShowNumber.setText("0")
        newOperation = true
    }

}
