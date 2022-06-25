package com.example.money

import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import java.net.HttpURLConnection
import java.net.URL


class ExpensesService {
    fun GetExpenses():List<ExpenseDto>{

    try{
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val url = URL("http://51.250.109.137/money/api/expenses/")

        with(url.openConnection() as HttpURLConnection) {
            inputStream.bufferedReader().use {
                var resp = it.readText()
            }
        }

    }
    catch(e: Exception){
        println("exception:")
        println(e.message)
    }
        return listOf(
            ExpenseDto("Bus ticket", 41),
            ExpenseDto("Chiefburger", 150),
            ExpenseDto("Internet", 800))
    }
}