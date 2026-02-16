package com.imkaem.android.svarctoo.features.expenses.domain.usecase

import com.imkaem.android.svarctoo.features.expenses.domain.model.Expense
import com.imkaem.android.svarctoo.features.expenses.domain.repository.ExpenseRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * UseCase for updating an existing expense.
 * Marked as @Singleton for efficiency (stateless business logic).
 * Note: @Singleton could be removed in future if per-screen instances are needed.
 */
@Singleton
class UpdateExpenseUseCase @Inject constructor(
    private val repository: ExpenseRepository
) {
    suspend operator fun invoke(expense: Expense): Boolean {
        return repository.updateExpense(expense)
    }
}
