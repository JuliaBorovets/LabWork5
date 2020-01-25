package com.example.labwork5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var result: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE) //will hide the title
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.result)

        val listener = View.OnClickListener {
            matrix()
        }

        button.setOnClickListener(listener)
    }

    private fun matrix() {

        try {
            result?.text = " "
            val coeff: Array<DoubleArray> = arrayOf(
                doubleArrayOf(
                    a11.text.toString().toDouble(),
                    a12.text.toString().toDouble(),
                    a13.text.toString().toDouble(),
                    a14.text.toString().toDouble()
                ),
                doubleArrayOf(
                    a21.text.toString().toDouble(),
                    a22.text.toString().toDouble(),
                    a23.text.toString().toDouble(),
                    a24.text.toString().toDouble()
                ),
                doubleArrayOf(
                    a31.text.toString().toDouble(),
                    a32.text.toString().toDouble(),
                    a33.text.toString().toDouble(),
                    a34.text.toString().toDouble()
                ),
                doubleArrayOf(
                    a41.text.toString().toDouble(),
                    a42.text.toString().toDouble(),
                    a43.text.toString().toDouble(),
                    a44.text.toString().toDouble()
                )
            )

            val freeValues: DoubleArray = doubleArrayOf(
                x1.text.toString().toDouble(),
                x2.text.toString().toDouble(),
                x3.text.toString().toDouble(),
                x4.text.toString().toDouble()
            )

            val equation = Work()
            val res = equation.solve(coeff, freeValues)
            for (char in res) {
                result?.append(char.toString())
                result?.append("  \n \n")

            }

        } catch (e: Exception) {

            result?.append("Помилка! \n")

        }
    }
}

