package com.imkaem.android.svarctoo.models

import java.time.Instant

data class Expense(
    val id: Long,
    val description: String,
    val amount: Double,
    val date: Instant,
    val category: String
)
