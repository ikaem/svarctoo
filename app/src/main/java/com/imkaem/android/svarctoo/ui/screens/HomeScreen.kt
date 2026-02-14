package com.imkaem.android.svarctoo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
    // Placeholder for Section 1
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
