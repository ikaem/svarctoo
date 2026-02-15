package com.imkaem.android.svarctoo.features.home.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imkaem.android.svarctoo.core.models.DummyExpenseData
import com.imkaem.android.svarctoo.core.theme.Primary
import com.imkaem.android.svarctoo.core.theme.Secondary
import com.imkaem.android.svarctoo.core.theme.Tertiary
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            DailyBudgetSection()
        }

        item {
            TodayExpenseSummarySection()
        }

        item {
            CurrentMonthSummarySection()
        }

        item {
            LatestExpensesSection()
        }
    }
}

@Composable
private fun DailyBudgetSection() {
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
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$33.33",
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
private fun TodayExpenseSummarySection() {
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
                        text = "$15.50",
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
                        text = "$17.83",
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
                        text = "$5.25",
                        style = MaterialTheme.typography.titleLarge,
                        color = Secondary
                    )
                }
            }
        }
    }
}

@Composable
private fun CurrentMonthSummarySection() {
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
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Spent",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "$245.80",
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
                        text = "$754.20",
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
                        text = "$1000.00",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Composable
private fun LatestExpensesSection() {
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
                DummyExpenseData.sampleExpenses.take(5).forEach { expense ->
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
