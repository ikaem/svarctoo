package com.imkaem.android.svarctoo.features.expenses.data.repository

import com.imkaem.android.svarctoo.features.expenses.data.datasource.ExpenseDataSource
import com.imkaem.android.svarctoo.features.expenses.domain.model.Expense
import com.imkaem.android.svarctoo.features.expenses.domain.repository.ExpenseRepository
import java.time.Instant

class ExpenseRepositoryImpl(
    private val dataSource: ExpenseDataSource
) : ExpenseRepository {

    override suspend fun getExpenses(): List<Expense> {
        return dataSource.getExpenses()
    }

    override suspend fun getExpense(id: Long): Expense? {
        return dataSource.getExpense(id)
    }

    override suspend fun addExpense(
        description: String,
        amount: Double,
        category: String,
        date: Instant
    ): Long {
        return dataSource.addExpense(description, amount, category, date)
    }

    override suspend fun updateExpense(expense: Expense): Boolean {
        return dataSource.updateExpense(expense)
    }

    override suspend fun deleteExpense(id: Long): Boolean {
        return dataSource.deleteExpense(id)
    }
}
