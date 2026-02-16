package com.imkaem.android.svarctoo.features.expenses.domain.usecase

import com.imkaem.android.svarctoo.features.expenses.domain.model.Expense
import com.imkaem.android.svarctoo.features.expenses.domain.repository.ExpenseRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * UseCase for retrieving a single expense by ID.
 * Marked as @Singleton for efficiency (stateless business logic).
 * Note: @Singleton could be removed in future if per-screen instances are needed.
 */
@Singleton
class GetExpenseByIdUseCase @Inject constructor(
    private val repository: ExpenseRepository
) {
    suspend operator fun invoke(id: Long): Expense? {
        return repository.getExpense(id)
    }
}
