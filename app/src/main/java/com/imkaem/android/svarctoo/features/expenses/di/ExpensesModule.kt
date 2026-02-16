package com.imkaem.android.svarctoo.features.expenses.di

import com.imkaem.android.svarctoo.features.expenses.data.datasource.ExpenseDataSource
import com.imkaem.android.svarctoo.features.expenses.data.datasource.ExpenseDataSourceImpl
import com.imkaem.android.svarctoo.features.expenses.data.repository.ExpenseRepositoryImpl
import com.imkaem.android.svarctoo.features.expenses.domain.repository.ExpenseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt module for expenses feature dependencies.
 * 
 * ARCHITECTURE DECISION:
 * - DataSource & Repository: Provided via @Provides (infrastructure layer)
 *   Rationale: Keeps implementations framework-agnostic. Easy to swap implementations,
 *   add conditional logic, or switch DI frameworks in future without touching implementations.
 * 
 * - UseCases: Auto-wired via @Inject constructors (domain/business logic layer)
 *   Rationale: Pure business logic should not import Hilt. Stateless wrappers don't need
 *   special provider logic. Cleaner, more idiomatic Kotlin.
 * 
 * This separation keeps infrastructure away from business logic while minimizing boilerplate.
 */
@Module
@InstallIn(SingletonComponent::class)
object ExpensesModule {

    @Singleton
    @Provides
    fun provideExpenseDataSource(): ExpenseDataSource {
        return ExpenseDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideExpenseRepository(
        dataSource: ExpenseDataSource
    ): ExpenseRepository {
        return ExpenseRepositoryImpl(dataSource)
    }
    
    // UseCases are NOT provided here - they auto-wire via @Inject constructors
    // This is cleaner and more idiomatic than providing every UseCase explicitly
}
