package com.imkaem.android.svarctoo.features.expenses.domain.usecase

import com.imkaem.android.svarctoo.features.expenses.domain.repository.ExpenseRepository

class DeleteExpenseUseCase(
    private val repository: ExpenseRepository
) {
    suspend fun execute(id: Long): Boolean {
        return repository.deleteExpense(id)
    }
}
