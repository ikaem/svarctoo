package com.imkaem.android.svarctoo.features.home.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imkaem.android.svarctoo.core.di.ViewModelFactory
import com.imkaem.android.svarctoo.core.theme.Primary
import com.imkaem.android.svarctoo.core.theme.Secondary
import com.imkaem.android.svarctoo.core.theme.Tertiary
import com.imkaem.android.svarctoo.features.home.presentation.viewmodel.HomeUiState
import com.imkaem.android.svarctoo.features.home.presentation.viewmodel.HomeViewModel
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = viewModel(
        factory = object : androidx.lifecycle.ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                return ViewModelFactory.createHomeViewModel() as T
            }
        }
    )
) {
    val uiState = homeViewModel.uiState.collectAsState()

    when (val currentState = uiState.value) {
        is HomeUiState.Loading -> {
            LoadingScreen(modifier)
        }
        is HomeUiState.Success -> {
            SuccessScreen(
                modifier = modifier,
                uiState = currentState
            )
        }
        is HomeUiState.Error -> {
            ErrorScreen(
                modifier = modifier,
                errorMessage = currentState.message
            )
        }
    }
}

@Composable
private fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun SuccessScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUiState.Success
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            DailyBudgetSection(uiState.dailyBudget)
        }

        item {
            TodayExpenseSummarySection(
                todaySpent = uiState.todaySpent,
                todayRemainder = uiState.todayRemainder,
                accumulatedRemainder = uiState.accumulatedRemainder
            )
        }

        item {
            CurrentMonthSummarySection(
                monthSpent = uiState.monthSpent,
                monthRemainder = uiState.monthRemainder,
                monthBudget = uiState.monthBudget
            )
        }

        item {
            LatestExpensesSection(uiState.recentExpenses)
        }
    }
}

@Composable
private fun ErrorScreen(
    modifier: Modifier = Modifier,
    errorMessage: String?
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Error: ${errorMessage ?: "Unknown error"}",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun DailyBudgetSection(dailyBudget: Double = 0.0) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        colors = CardDefaults.cardColors()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Daily Budget",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$${"%.2f".format(dailyBudget)}",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Primary
                )
                Button(onClick = { /* TODO: Handle add expense */ }) {
                    Text("Add Expense")
                }
            }
        }
    }
}

@Composable
private fun TodayExpenseSummarySection(
    todaySpent: Double = 0.0,
    todayRemainder: Double = 0.0,
    accumulatedRemainder: Double = 0.0
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        colors = CardDefaults.cardColors()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Today's Summary",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Spent",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "$${"%.2f".format(todaySpent)}",
                        style = MaterialTheme.typography.titleLarge,
                        color = Tertiary
                    )
                }
                Column {
                    Text(
                        text = "Remainder",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "$${"%.2f".format(todayRemainder)}",
                        style = MaterialTheme.typography.titleLarge,
                        color = Primary
                    )
                }
                Column {
                    Text(
                        text = "Accumulated",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "$${"%.2f".format(accumulatedRemainder)}",
                        style = MaterialTheme.typography.titleLarge,
                        color = Secondary
                    )
                }
            }
        }
    }
}

@Composable
private fun CurrentMonthSummarySection(
    monthSpent: Double = 0.0,
    monthRemainder: Double = 0.0,
    monthBudget: Double = 0.0
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        colors = CardDefaults.cardColors()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "This Month",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Spent",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "$${"%.2f".format(monthSpent)}",
                        style = MaterialTheme.typography.titleLarge,
                        color = Tertiary
                    )
                }
                Column {
                    Text(
                        text = "Remainder",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "$${"%.2f".format(monthRemainder)}",
                        style = MaterialTheme.typography.titleLarge,
                        color = Primary
                    )
                }
                Column {
                    Text(
                        text = "Budget",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "$${"%.2f".format(monthBudget)}",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Composable
private fun LatestExpensesSection(
    recentExpenses: List<com.imkaem.android.svarctoo.features.expenses.domain.model.Expense> = emptyList()
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        colors = CardDefaults.cardColors()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Latest Expenses",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                if (recentExpenses.isEmpty()) {
                    Text(
                        text = "No expenses yet",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(16.dp)
                    )
                } else {
                    recentExpenses.forEach { expense ->
                        ExpenseItem(
                            amount = expense.amount,
                            description = expense.description,
                            date = expense.date
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ExpenseItem(
    amount: Double,
    description: String,
    date: java.time.Instant
) {
    val formatter = DateTimeFormatter.ofPattern("MMM d, h:mm a")
        .withZone(ZoneId.systemDefault())
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = formatter.format(date),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Text(
            text = "$$amount",
            style = MaterialTheme.typography.bodySmall,
            color = Tertiary,
        )
    }
    HorizontalDivider()
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
