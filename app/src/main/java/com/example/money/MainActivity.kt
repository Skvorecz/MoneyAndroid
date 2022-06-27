package com.example.money

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val service : ExpensesService = ExpensesService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val expenses = initializeExpenses()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = ExpenseAdapter(expenses)
        recyclerView.adapter = adapter
    }

    private fun initializeExpenses(): List<ExpenseDto> {
        return service.getExpenses()
    }
}