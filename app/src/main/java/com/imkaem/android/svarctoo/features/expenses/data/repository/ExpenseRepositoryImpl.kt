package com.imkaem.android.svarctoo.features.expenses.data.repository

import com.imkaem.android.svarctoo.core.models.DummyExpenseData
import com.imkaem.android.svarctoo.features.expenses.domain.model.Expense
import com.imkaem.android.svarctoo.features.expenses.domain.repository.ExpenseRepository

class ExpenseRepositoryImpl : ExpenseRepository {

    override suspend fun getExpenses(): List<Expense> {
        // Return a copy of the list to prevent external modification
        return DummyExpenseData.sampleExpenses.toList()
    }

    override suspend fun getExpense(id: Long): Expense? {
        return DummyExpenseData.sampleExpenses.find { it.id == id }
    }

    override suspend fun addExpense(expense: Expense): Boolean {
        return DummyExpenseData.sampleExpenses.add(expense)
    }

    override suspend fun updateExpense(expense: Expense): Boolean {
        val index = DummyExpenseData.sampleExpenses.indexOfFirst { it.id == expense.id }
        return if (index != -1) {
            DummyExpenseData.sampleExpenses[index] = expense
            true
        } else {
            false
        }
    }

    override suspend fun deleteExpense(id: Long): Boolean {
        return DummyExpenseData.sampleExpenses.removeIf { it.id == id }
    }
}
