package com.example.money

import kotlinx.serialization.Serializable

@Serializable
data class ExpenseDto(val name: String, val cost: Int)