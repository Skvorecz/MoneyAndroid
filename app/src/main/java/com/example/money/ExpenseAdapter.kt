package com.example.money

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpenseAdapter(private val expenses: List<ExpenseDto>) : RecyclerView.Adapter<ExpenseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ExpenseAdapter.ViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.expense_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val expense = expenses[position]
        holder.nameTextView.text = expense.name
        holder.costTextView.text = expense.cost.toString()
    }

    override fun getItemCount(): Int {
        return expenses.size
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val nameTextView = view.findViewById<TextView>(R.id.nameTextView)
        val costTextView = view.findViewById<TextView>(R.id.costTextView)
    }
}