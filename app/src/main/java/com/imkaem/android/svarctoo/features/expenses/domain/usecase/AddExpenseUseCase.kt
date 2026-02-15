package com.imkaem.android.svarctoo.features.expenses.domain.usecase

import com.imkaem.android.svarctoo.features.expenses.domain.repository.ExpenseRepository
import java.time.Instant

class AddExpenseUseCase(
    private val repository: ExpenseRepository
) {
    suspend operator fun invoke(
        description: String,
        amount: Double,
        category: String,
        date: Instant
    ): Long {
        return repository.addExpense(description, amount, category, date)
    }
}
