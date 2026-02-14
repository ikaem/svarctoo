package com.imkaem.android.svarctoo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Section 1: Daily budget header
        DailyBudgetSection()

        // Section 2: Today's expense summary
        TodayExpenseSummarySection()

        // Section 3: Current month summary
        CurrentMonthSummarySection()

        // Section 4: Latest expenses list
        LatestExpensesSection()
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
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$33.33",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
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
    // Placeholder for Section 2
}

@Composable
private fun CurrentMonthSummarySection() {
    // Placeholder for Section 3
}

@Composable
private fun LatestExpensesSection() {
    // Placeholder for Section 4
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
