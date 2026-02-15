package com.imkaem.android.svarctoo.features.expenses.domain.usecase

import com.imkaem.android.svarctoo.features.expenses.domain.model.Expense
import com.imkaem.android.svarctoo.features.expenses.domain.repository.ExpenseRepository

class GetAllExpensesUseCase(
    private val repository: ExpenseRepository
) {
    suspend fun execute(): List<Expense> {
        return repository.getExpenses()
    }
}
