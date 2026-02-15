package com.imkaem.android.svarctoo.core.models

import com.imkaem.android.svarctoo.features.expenses.domain.model.Expense
import java.time.Instant
import java.time.temporal.ChronoUnit

object DummyExpenseData {
    val sampleExpenses: MutableList<Expense> = mutableListOf(
        Expense(
            id = 1,
            description = "Coffee",
            amount = 5.50,
            date = Instant.now(),
            category = "Food & Drinks"
        ),
        Expense(
            id = 2,
            description = "Groceries",
            amount = 45.30,
            date = Instant.now().minus(2, ChronoUnit.HOURS),
            category = "Groceries"
        ),
        Expense(
            id = 3,
            description = "Gas",
            amount = 55.00,
            date = Instant.now().minus(1, ChronoUnit.DAYS),
            category = "Transportation"
        ),
        Expense(
            id = 4,
            description = "Restaurant Dinner",
            amount = 32.75,
            date = Instant.now().minus(2, ChronoUnit.DAYS),
            category = "Food & Drinks"
        ),
        Expense(
            id = 5,
            description = "Movie Tickets",
            amount = 28.00,
            date = Instant.now().minus(3, ChronoUnit.DAYS),
            category = "Entertainment"
        ),
        Expense(
            id = 6,
            description = "Internet Bill",
            amount = 79.99,
            date = Instant.now().minus(5, ChronoUnit.DAYS),
            category = "Utilities"
        ),
        Expense(
            id = 7,
            description = "Gym Membership",
            amount = 50.00,
            date = Instant.now().minus(7, ChronoUnit.DAYS),
            category = "Health & Fitness"
        ),
        Expense(
            id = 8,
            description = "Book",
            amount = 15.99,
            date = Instant.now().minus(10, ChronoUnit.DAYS),
            category = "Entertainment"
        )
    )
}

