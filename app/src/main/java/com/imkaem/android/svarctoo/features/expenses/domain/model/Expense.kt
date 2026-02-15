package com.imkaem.android.svarctoo.features.expenses.domain.model

import java.time.Instant

data class Expense(
    val id: Long,
    val description: String,
    val amount: Double,
    val date: Instant,
    val category: String
)
