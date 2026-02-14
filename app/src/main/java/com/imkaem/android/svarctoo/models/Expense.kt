package com.imkaem.android.svarctoo.models

import java.time.LocalDate

data class Expense(
    val id: Long,
    val description: String,
    val amount: Double,
    val date: LocalDate,
    val category: String
)
