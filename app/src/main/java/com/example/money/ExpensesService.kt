package com.example.money

class ExpensesService {
    fun GetExpenses():List<ExpenseDto>{
        return listOf(
            ExpenseDto("Bus ticket", 41),
            ExpenseDto("Chiefburger", 150),
            ExpenseDto("Internet", 800))
    }
}