package com.imkaem.android.svarctoo.features.expenses.domain.repository

import com.imkaem.android.svarctoo.features.expenses.domain.model.Expense

interface ExpenseRepository {
    suspend fun getExpenses(): List<Expense>
    suspend fun getExpense(id: Long): Expense?
    suspend fun addExpense(expense: Expense): Boolean
    suspend fun updateExpense(expense: Expense): Boolean
    suspend fun deleteExpense(id: Long): Boolean
}
