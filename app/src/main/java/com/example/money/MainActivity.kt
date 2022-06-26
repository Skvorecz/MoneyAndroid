package com.example.money

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val service: ExpensesService = ExpensesService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeExpenses()
    }

    private fun initializeExpenses(){
        val expenses = service.getExpenses()
        val layout = findViewById<LinearLayout>(R.id.linearLayout)

        for (e in expenses){
            val textView = TextView(baseContext)
            textView.text = "${e.name} : ${e.cost}"
            layout.addView(textView)
        }
    }
}