package com.imkaem.android.svarctoo.features.expenses.domain.usecase

import com.imkaem.android.svarctoo.features.expenses.domain.repository.ExpenseRepository

class DeleteExpenseUseCase(
    private val repository: ExpenseRepository
) {
    suspend operator fun invoke(id: Long): Boolean {
        return repository.deleteExpense(id)
    }
}
