package com.example.money

import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection
import java.net.URL

class ExpensesService {
    public fun getExpenses(): List<ExpenseDto> {
        val json = getExpensesFromService()

        return parseExpenses(json)
    }

    private fun getExpensesFromService() : String {
        try {
            val policy = ThreadPolicy
                .Builder()
                .permitAll()
                .build()
            StrictMode.setThreadPolicy(policy)

            val url = URL("http://84.252.143.247/money/api/expenses/")
            with(url.openConnection() as HttpURLConnection) {
                inputStream.bufferedReader().use {
                    return it.readText()
                }
            }
        }
        catch (e: Exception) {
            return ""
        }
    }

    private fun parseExpenses(json: String): List<ExpenseDto> {
        return Json.decodeFromString(json)
    }
}