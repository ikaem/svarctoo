package com.imkaem.android.svarctoo.features.expenses.domain.usecase

import com.imkaem.android.svarctoo.features.expenses.domain.model.Expense
import com.imkaem.android.svarctoo.features.expenses.domain.repository.ExpenseRepository

class UpdateExpenseUseCase(
    private val repository: ExpenseRepository
) {
    suspend fun execute(expense: Expense): Boolean {
        return repository.updateExpense(expense)
    }
}
