package com.imkaem.android.svarctoo.features.expenses.domain.usecase

import com.imkaem.android.svarctoo.features.expenses.domain.repository.ExpenseRepository
import java.time.Instant
import javax.inject.Inject
import javax.inject.Singleton

/**
 * UseCase for adding a new expense.
 * Marked as @Singleton for efficiency (stateless business logic).
 * Note: @Singleton could be removed in future if per-screen instances are needed.
 */
@Singleton
class AddExpenseUseCase @Inject constructor(
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
