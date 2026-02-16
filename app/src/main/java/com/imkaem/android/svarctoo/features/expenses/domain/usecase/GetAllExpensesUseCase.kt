package com.imkaem.android.svarctoo.features.expenses.domain.usecase

import com.imkaem.android.svarctoo.features.expenses.domain.model.Expense
import com.imkaem.android.svarctoo.features.expenses.domain.repository.ExpenseRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import javax.inject.Singleton

/**
 * UseCase for retrieving all expenses.
 * Marked as @Singleton for efficiency (stateless business logic).
 * Note: @Singleton could be removed in future if per-screen instances are needed.
 */
@Singleton
class GetAllExpensesUseCase @Inject constructor(
    private val repository: ExpenseRepository
) {
    suspend operator fun invoke(): List<Expense> {
        return repository.getExpenses()
    }
}
