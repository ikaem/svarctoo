package com.imkaem.android.svarctoo.features.expenses.data.datasource

import com.imkaem.android.svarctoo.features.expenses.domain.model.Expense
import java.time.Instant

interface ExpenseDataSource {
    suspend fun getExpenses(): List<Expense>
    suspend fun getExpense(id: Long): Expense?
    suspend fun addExpense(description: String, amount: Double, category: String, date: Instant): Long
    suspend fun updateExpense(expense: Expense): Boolean
    suspend fun deleteExpense(id: Long): Boolean
}
