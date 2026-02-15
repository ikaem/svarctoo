package com.imkaem.android.svarctoo.features.expenses.domain.usecase

import com.imkaem.android.svarctoo.features.expenses.domain.model.Expense
import com.imkaem.android.svarctoo.features.expenses.domain.repository.ExpenseRepository

class GetAllExpensesUseCase(
    private val repository: ExpenseRepository
) {
    suspend operator fun invoke(): List<Expense> {
        return repository.getExpenses()
    }
}
