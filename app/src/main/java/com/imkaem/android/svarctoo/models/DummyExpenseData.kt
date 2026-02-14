package com.imkaem.android.svarctoo.models

import java.time.LocalDate

object DummyExpenseData {
    val sampleExpenses = listOf(
        Expense(
            id = 1,
            description = "Coffee",
            amount = 5.50,
            date = LocalDate.now(),
            category = "Food & Drinks"
        ),
        Expense(
            id = 2,
            description = "Groceries",
            amount = 45.30,
            date = LocalDate.now(),
            category = "Groceries"
        ),
        Expense(
            id = 3,
            description = "Gas",
            amount = 55.00,
            date = LocalDate.now().minusDays(1),
            category = "Transportation"
        ),
        Expense(
            id = 4,
            description = "Restaurant Dinner",
            amount = 32.75,
            date = LocalDate.now().minusDays(2),
            category = "Food & Drinks"
        ),
        Expense(
            id = 5,
            description = "Movie Tickets",
            amount = 28.00,
            date = LocalDate.now().minusDays(3),
            category = "Entertainment"
        ),
        Expense(
            id = 6,
            description = "Internet Bill",
            amount = 79.99,
            date = LocalDate.now().minusDays(5),
            category = "Utilities"
        ),
        Expense(
            id = 7,
            description = "Gym Membership",
            amount = 50.00,
            date = LocalDate.now().minusDays(7),
            category = "Health & Fitness"
        ),
        Expense(
            id = 8,
            description = "Book",
            amount = 15.99,
            date = LocalDate.now().minusDays(10),
            category = "Entertainment"
        )
    )
}
