package com.imkaem.android.svarctoo.core.di

import com.imkaem.android.svarctoo.core.models.DummyExpenseData
import com.imkaem.android.svarctoo.features.expenses.data.datasource.ExpenseDataSourceImpl
import com.imkaem.android.svarctoo.features.expenses.data.repository.ExpenseRepositoryImpl
import com.imkaem.android.svarctoo.features.expenses.domain.usecase.GetAllExpensesUseCase
import com.imkaem.android.svarctoo.features.home.presentation.viewmodel.HomeViewModel

/**
 * Factory for creating ViewModels with manual dependency injection.
 * This is a temporary solution before Hilt is implemented (Step 12).
 */
object ViewModelFactory {

    fun createHomeViewModel(): HomeViewModel {
        // Wire up the dependency graph manually
        val dataSource = ExpenseDataSourceImpl(DummyExpenseData.expenses)
        val repository = ExpenseRepositoryImpl(dataSource)
        val getAllExpensesUseCase = GetAllExpensesUseCase(repository)

        return HomeViewModel(getAllExpensesUseCase)
    }
}
