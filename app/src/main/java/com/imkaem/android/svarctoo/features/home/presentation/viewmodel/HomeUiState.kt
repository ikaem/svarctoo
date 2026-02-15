package com.imkaem.android.svarctoo.features.home.presentation.viewmodel

import com.imkaem.android.svarctoo.features.expenses.domain.model.Expense

sealed class HomeUiState {
    object Loading : HomeUiState()

    data class Success(
        val dailyBudget: Double,
        val todaySpent: Double,
        val todayRemainder: Double,
        val accumulatedRemainder: Double,
        val monthSpent: Double,
        val monthRemainder: Double,
        val monthBudget: Double,
        val recentExpenses: List<Expense>
    ) : HomeUiState()

    data class Error(
        val message: String?
    ) : HomeUiState()
}
