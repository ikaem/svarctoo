package com.imkaem.android.svarctoo.features.home.presentation.viewmodel

//import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imkaem.android.svarctoo.features.expenses.domain.usecase.GetAllExpensesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

class HomeViewModel(
    private val getAllExpensesUseCase: GetAllExpensesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadHomeData()
    }

    fun loadHomeData() {
        viewModelScope.launch {
            try {
                _uiState.value = HomeUiState.Loading

                // Fetch all expenses
                val allExpenses = getAllExpensesUseCase()

                // Define daily budget (can be made configurable later)
                val dailyBudget = 50.0

                // Get today's date in UTC
                val today = LocalDate.now(ZoneId.of("UTC"))
                val todayStart = today.atStartOfDay(ZoneId.of("UTC")).toInstant()
                val todayEnd = today.atTime(23, 59, 59).atZone(ZoneId.of("UTC")).toInstant()

                // Calculate today's expenses
                val todayExpenses = allExpenses.filter { expense ->
                    expense.date >= todayStart && expense.date <= todayEnd
                }
                val todaySpent = todayExpenses.sumOf { it.amount }
                val todayRemainder = dailyBudget - todaySpent

                // Calculate accumulated remainder (simplified - can be enhanced)
                val accumulatedRemainder = 0.0 // Placeholder for now

                // Get month start and end
                val monthStart = today.withDayOfMonth(1)
                    .atStartOfDay(ZoneId.of("UTC")).toInstant()
                val monthEnd = today.withDayOfMonth(today.lengthOfMonth())
                    .atTime(23, 59, 59).atZone(ZoneId.of("UTC")).toInstant()

                // Calculate month expenses
                val monthExpenses = allExpenses.filter { expense ->
                    expense.date >= monthStart && expense.date <= monthEnd
                }
                val monthSpent = monthExpenses.sumOf { it.amount }
                val monthBudget = dailyBudget * today.lengthOfMonth()
                val monthRemainder = monthBudget - monthSpent

                // Get recent expenses (last 10)
                val recentExpenses = allExpenses.sortedByDescending { it.date }.take(10)

                _uiState.value = HomeUiState.Success(
                    dailyBudget = dailyBudget,
                    todaySpent = todaySpent,
                    todayRemainder = todayRemainder,
                    accumulatedRemainder = accumulatedRemainder,
                    monthSpent = monthSpent,
                    monthRemainder = monthRemainder,
                    monthBudget = monthBudget,
                    recentExpenses = recentExpenses
                )
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(e.message)
            }
        }
    }
}
