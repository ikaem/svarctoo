package com.imkaem.android.svarctoo.features.expenses.data.datasource

import com.imkaem.android.svarctoo.core.models.DummyExpenseData
import com.imkaem.android.svarctoo.features.expenses.domain.model.Expense
import java.time.Instant

class ExpenseDataSourceImpl : ExpenseDataSource {

    override suspend fun getExpenses(): List<Expense> {
        // Return a copy of the list to prevent external modification
        return DummyExpenseData.sampleExpenses.toList()
    }

    override suspend fun getExpense(id: Long): Expense? {
        return DummyExpenseData.sampleExpenses.find { it.id == id }
    }

    override suspend fun addExpense(
        description: String,
        amount: Double,
        category: String,
        date: Instant
    ): Long {
        // Generate the next ID (auto-increment style)
        val nextId = (DummyExpenseData.sampleExpenses.maxOfOrNull { it.id } ?: 0) + 1
        
        val newExpense = Expense(
            id = nextId,
            description = description,
            amount = amount,
            date = date,
            category = category
        )
        
        DummyExpenseData.sampleExpenses.add(newExpense)
        return nextId
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
