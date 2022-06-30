package com.example.money

import android.content.Intent
import android.os.Bundle
import android.view.View
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

    public fun onCreateClick(view : View)
    {
        val intent = Intent(this, CreateExpenseActivity::class.java)
        startActivity(intent)
    }

    private fun initializeExpenses(): List<ExpenseDto> {
        return service.getExpenses()
    }
}