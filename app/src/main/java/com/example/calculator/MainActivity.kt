package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import javax.xml.xpath.XPathExpressionException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Number
        tvOne.setOnClickListener { appenOnExpression("1", true) }
        tvTwo.setOnClickListener { appenOnExpression("2", true) }
        tvThree.setOnClickListener { appenOnExpression("3", true) }
        tvFour.setOnClickListener { appenOnExpression("4", true) }
        tvFive.setOnClickListener { appenOnExpression("5", true) }
        tvSix.setOnClickListener { appenOnExpression("6", true) }
        tvSeven.setOnClickListener { appenOnExpression("7", true) }
        tvEight.setOnClickListener { appenOnExpression("8", true) }
        tvNine.setOnClickListener { appenOnExpression("9", true) }
        tvZero.setOnClickListener { appenOnExpression("0", true) }
        tvDot.setOnClickListener { appenOnExpression(".", true) }
        //Operatos
        tvPlus.setOnClickListener { appenOnExpression("+", false) }
        tvMinus.setOnClickListener { appenOnExpression("-", false) }
        tvMul.setOnClickListener { appenOnExpression("*", false) }
        tvDivide.setOnClickListener { appenOnExpression("/", false) }
        tvOpen.setOnClickListener { appenOnExpression("(", false) }
        tvClose.setOnClickListener { appenOnExpression(")", false) }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }
        tvBack.setOnClickListener {
            val string = tvExpression.text.toString()
            if (string.isNotEmpty()) {
                tvExpression.text = string.substring(0, string.length - 1)

            }
            tvResult.text = ""
        }

        tvEquals.setOnClickListener {
            try {

                val expression = ExpressionBuilder(tvExpression.text.toString()) .build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                     tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()


            }catch (e:Exception){
                Log.d("Exception", "massage : " + e.message)

            }
        }

    }


    fun appenOnExpression(string: String, canClear: Boolean) {
        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""

        }
        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }
}






