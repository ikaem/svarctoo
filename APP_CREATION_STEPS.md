# An app for tracking my expenses and budget.

# Android Compose App Creation Steps

## Git Workflow

- Create one branch per step with descriptive names (e.g., `feature/step-1-project-structure`, `feature/step-2-models-and-data`)
- Branch from `master` for each step
- After completing each subtask, mark it as done in this file and commit immediately. use attomic commits for each subtask for simpler review and better commit history
- Do not wait for the entire step to finish before committing and updating the markdown
- Wait for approval before starting the next step
- Merge to `master` only after approval

## Prerequisites

- Android Studio installed (latest version)
- Android SDK 21+ installed
- Kotlin 1.8+
- Bootstrapped Kotlin Compose app

## Step 1: Create Project Structure

- [x] Task 1.1: Create package structure
  - [x] `com.example.svarcto.ui.screens`
  - [x] `com.example.svarcto.ui.theme`
  - [x] `com.example.svarcto.viewmodel`
  - [x] `com.example.svarcto.models`

## Step 2: Create Models & Dummy Data

- [x] Task 2.1: Create `Expense` data class with properties (id, description, amount, date, category)
- [x] Task 2.2: Create dummy expense data for testing

## Step 3: Build Home Screen Layout

- [x] Task 3.1: Create `HomeScreen` composable with vertical layout for 4 sections
- [x] Task 3.2: Build Section 1 - Daily budget header
  - Display current month's daily budget
  - Add "Add Expense" button
- [x] Task 3.3: Build Section 2 - Today's expense summary
  - Show total spent today
  - Show remainder for today (daily budget - spent)
  - Show accumulated remainder (leftover from previous days)
- [x] Task 3.4: Build Section 3 - Current month summary
  - Show total spent this month
  - Show total remainder for month
  - Show total budget for month
- [x] Task 3.5: Build Section 4 - Latest expenses list
  - Display recent expenses in brief format
  - Show amount, description, and date

## Step 4: Render HomeScreen in MainActivity

- [x] Task 4.1: Update MainActivity to display the HomeScreen composable
  - Import HomeScreen composable
  - Set HomeScreen as the content of the main composable function
  - Verify HomeScreen renders when app starts

## Step 4-Fix: Fix Nested Scrollable Components Crash

- [x] Task 4-Fix.1: Resolve LazyColumn nesting issue
  - Replace outer Column with verticalScroll with a single LazyColumn root
  - Convert each section to items in the LazyColumn
  - Replace inner LazyColumn in LatestExpensesSection with a regular Column using forEach
  - Eliminates infinite constraint error and scroll conflicts

## Step 5: Create Theme & Styling

- [x] Task 5.1: Define color scheme
- [x] Task 5.2: Define typography
- [x] Task 5.3: Apply theme to all composables

## Step 7: Refactor to Clean Architecture (Feature-Based)

Restructure codebase from flat structure to feature-based clean architecture:

```
app/src/main/java/com/imkaem/android/svarctoo/
├── features/
│   ├── home/
│   │   ├── presentation/
│   │   │   ├── screens/
│   │   │   │   └── HomeScreen.kt
│   │   │   └── viewmodel/
│   │   │       └── HomeViewModel.kt
│   │   ├── domain/
│   │   ├── data/
│   └── expenses/
│       ├── presentation/
│       │   ├── screens/
│       │   │   └── ExpensesListScreen.kt
│       │   └── viewmodel/
│       │       └── ExpensesViewModel.kt
│       ├── domain/
│       │   ├── model/
│       │   │   └── Expense.kt
│       │   └── usecase/
│       │       ├── GetExpensesUseCase.kt
│       │       ├── AddExpenseUseCase.kt
│       │       └── DeleteExpenseUseCase.kt
│       └── data/
│           ├── repository/
│           │   └── ExpenseRepository.kt
│           └── datasource/
│               └── ExpenseDataSource.kt
├── core/
│   ├── theme/
│   │   ├── Color.kt
│   │   ├── Type.kt
│   │   └── Theme.kt
│   ├── models/
│   │   └── DummyExpenseData.kt
│   └── util/
└── MainActivity.kt
```

- [x] Task 7.1: Create feature folder structure under `features/`
- [x] Task 7.2: Create `features/home/presentation/screens/` and move HomeScreen.kt
- [x] Task 7.3: Create `core/` folder and move theme files
- [x] Task 7.4: Move DummyExpenseData.kt to `core/models/`
- [x] Task 7.5: Delete old `ui/` and `models/` folders
- [x] Task 7.6: Update all imports throughout the app

## Step 8: Implement Data Layer Architecture

Create repository and data source interfaces/implementations:

- [x] Task 8.1: Create `features/expenses/domain/model/Expense.kt` data class
- [x] Task 8.2: Create `features/expenses/domain/repository/ExpenseRepository.kt` interface
  - `fun getExpenses(): List<Expense>`
  - `fun getExpense(id: Long): Expense?`
  - `fun addExpense(description, amount, category, date): Long` (returns generated ID)
  - `fun updateExpense(expense: Expense): Boolean`
  - `fun deleteExpense(id: Long): Boolean`
- [x] Task 8.3: Create `features/expenses/data/datasource/ExpenseDataSource.kt` interface
  - Same methods as repository, with ID generation in addExpense
- [x] Task 8.4: Create `features/expenses/data/repository/ExpenseRepositoryImpl.kt` implementation
  - Delegates to ExpenseDataSource
- [x] Task 8.5: Create `features/expenses/data/datasource/ExpenseDataSourceImpl.kt` implementation
  - Uses DummyExpenseData as backing store
  - Generates auto-increment IDs (maxId + 1)

## Step 9: Implement Use Cases (Domain Layer)

Create use cases for business logic:

- [x] Task 9.1: Create `features/expenses/domain/usecase/GetAllExpensesUseCase.kt`
- [x] Task 9.2: Create `features/expenses/domain/usecase/GetExpenseByIdUseCase.kt`
- [x] Task 9.3: Create `features/expenses/domain/usecase/AddExpenseUseCase.kt`
- [x] Task 9.4: Create `features/expenses/domain/usecase/UpdateExpenseUseCase.kt`
- [x] Task 9.5: Create `features/expenses/domain/usecase/DeleteExpenseUseCase.kt`
- [x] Task 9.6: Each UseCase takes a repository as constructor parameter

## Step 9-Fix: Use Operator Invoke Pattern in UseCases

Refactor use cases to use Kotlin's `operator invoke()` for more idiomatic code:

- [x] Task 9-Fix.1: Replace `execute()` with `operator invoke()` in all UseCases
  - GetAllExpensesUseCase: `suspend operator fun invoke(): List<Expense>`
  - GetExpenseByIdUseCase: `suspend operator fun invoke(id: Long): Expense?`
  - AddExpenseUseCase: `suspend operator fun invoke(...): Long`
  - UpdateExpenseUseCase: `suspend operator fun invoke(expense: Expense): Boolean`
  - DeleteExpenseUseCase: `suspend operator fun invoke(id: Long): Boolean`
  - Enables cleaner syntax: `useCase()` instead of `useCase.execute()`
  - Follows Kotlin idioms and industry standards

## Step 10: Create ViewModels (Presentation Layer)

Create ViewModels for managing UI state and business logic coordination:

**Best Practice:** One ViewModel per screen for independent state management.

- [x] Task 10.1: Create `features/home/presentation/viewmodel/HomeViewModel.kt`
  - Define `HomeUiState` sealed class with states: Loading, Success(data), Error(message)
  - Create `MutableStateFlow<HomeUiState>` and expose as `StateFlow`
  - Add methods to fetch home data (daily budget, today's summary, month's summary, recent expenses)
  - Use ViewModelScope for coroutine operations
- [x] Task 10.2: Create `features/home/presentation/viewmodel/HomeUiState.kt`
  - `sealed class HomeUiState`
  - `object Loading : HomeUiState()`
  - `data class Success(val dailyBudget: Double, val todayExpenses: List<Expense>, ...)`
  - `data class Error(val message: String?) : HomeUiState()`
- [x] Task 10.3: Create `features/expenses/presentation/viewmodel/ExpensesViewModel.kt` (for future use)
  - Basic skeleton for managing expenses list screen

## Step 11: Connect HomeViewModel to HomeScreen (Manual Instantiation)

Integrate HomeViewModel with HomeScreen using `viewModel()` composable without Hilt:

- [x] Task 11.1: Create a Factory function or dependency provider to create HomeViewModel
  - Manually instantiate GetAllExpensesUseCase with repository
  - Create HomeViewModel with the use case
- [x] Task 11.2: Update `HomeScreen` composable to accept HomeViewModel parameter
- [x] Task 11.3: Use `viewModel()` composable in HomeScreen to get ViewModel instance
  - Pass factory lambda to create HomeViewModel
- [x] Task 11.4: Collect HomeUiState from ViewModel in HomeScreen
  - Use `collectAsState()` on `uiState` StateFlow
- [x] Task 11.5: Render UI based on HomeUiState (Loading/Success/Error)
  - Display appropriate content for each state

## Step 11-Fix: Fix ViewModelFactory and Dependencies

Fix issues found during Step 11 integration:

- [x] Task 11-Fix.1: Fix ExpenseDataSourceImpl instantiation in ViewModelFactory
  - ExpenseDataSourceImpl does not accept constructor arguments
  - Need to verify how ExpenseDataSourceImpl accesses DummyExpenseData
  - Update ViewModelFactory instantiation accordingly
- [x] Task 11-Fix.2: Add lifecycle-viewmodel-compose dependency to build.gradle.kts
  - HomeScreen uses `viewModel()` composable function
  - Requires androidx.lifecycle:lifecycle-viewmodel-compose library
  - Add to app/build.gradle.kts dependencies

## Step 12: Setup Dependency Injection with Hilt

Configure Hilt for dependency injection:

- [x] Task 12.1: Add Hilt dependencies to build.gradle.kts
  - Add Hilt 2.51 and KSP 2.0.21-1.0.24
  - Use KSP instead of KAPT for faster annotation processing
- [x] Task 12.2: Create `HiltApplication.kt` and register in manifest
  - Extend Application and annotate with @HiltAndroidApp
  - Update AndroidManifest.xml to use HiltApplication as application class
- [x] Task 12.3: Create `features/expenses/di/ExpensesModule.kt` Hilt module
  - Provide ExpenseDataSource implementation
  - Provide ExpenseRepository implementation
  - UseCases auto-wired via @Inject constructors (not provided in module)
  - Architecture: Infrastructure in module (framework-agnostic), business logic auto-wired
- [x] Task 12.4: Create `core/di/CoreModule.kt` for shared dependencies
  - Placeholder for app-wide dependencies (database, preferences, logging, etc.)
  - Ready for future expansion as app grows

## Step 13: Connect Hilt to ViewModels and Inject Dependencies

Inject dependencies into ViewModels:

- [ ] Task 13.1: Add `@HiltViewModel` annotation to `HomeViewModel`
  - Inject necessary UseCases via constructor
- [ ] Task 13.2: Add `@HiltViewModel` annotation to `ExpensesViewModel`
  - Inject UseCases
- [ ] Task 13.3: Update `MainActivity.kt` to use `@AndroidEntryPoint`
- [ ] Task 13.4: Update HomeScreen to use Hilt-injected HomeViewModel
- [ ] Task 13.5: Verify Hilt injection works (build and test)

## Step 14: Implement CRUD Operations with Dummy Data

Test full application flow with dummy data (no database yet):

- [ ] Task 14.1: Implement "Get All Expenses" - fetch and display in HomeScreen
- [ ] Task 14.2: Implement "Add Expense" - create new expense and update state
- [ ] Task 14.3: Implement "Update Expense" - modify existing expense
- [ ] Task 14.4: Implement "Delete Expense" - remove expense from list
- [ ] Task 14.5: Update HomeViewModel to populate UI state with real data from UseCases
- [ ] Task 14.6: Update HomeScreen composables to display data from ViewModel state
- [ ] Task 14.7: Test all CRUD operations with dummy data backing

## Step 15: Implement Room Database

Setup local persistent database with Room:

- [ ] Task 14.1: Add Room dependencies to build.gradle.kts
- [ ] Task 14.2: Create `features/expenses/data/local/database/ExpenseDatabase.kt` (Room database)
- [ ] Task 14.3: Create `features/expenses/data/local/dao/ExpenseDao.kt` (Data Access Object)
  - Define query functions matching CRUD operations
- [ ] Task 14.4: Create `features/expenses/data/local/entity/ExpenseEntity.kt` (Room entity)
  - Map domain Expense model to database entity
- [ ] Task 14.5: Create entity/domain mappers to convert between ExpenseEntity and Expense

## Step 15: Implement Room Database

Setup local persistent database with Room:

- [ ] Task 15.1: Add Room dependencies to build.gradle.kts
- [ ] Task 15.2: Create `features/expenses/data/local/database/ExpenseDatabase.kt` (Room database)
- [ ] Task 15.3: Create `features/expenses/data/local/dao/ExpenseDao.kt` (Data Access Object)
  - Define query functions matching CRUD operations
- [ ] Task 15.4: Create `features/expenses/data/local/entity/ExpenseEntity.kt` (Room entity)
  - Map domain Expense model to database entity
- [ ] Task 15.5: Create entity/domain mappers to convert between ExpenseEntity and Expense

## Step 16: Connect Data Layer to Room Database

Replace dummy data with actual database operations:

- [ ] Task 16.1: Update `features/expenses/data/datasource/ExpenseDataSourceImpl.kt`
  - Replace dummy data logic with Room DAO calls
- [ ] Task 16.2: Update Hilt module to provide Room database and DAO
- [ ] Task 16.3: Test CRUD operations with Room database
- [ ] Task 16.4: Verify data persists across app restarts

## Step 17: Unit Testing

Add comprehensive unit tests:

- [ ] Task 17.1: Create tests for all UseCases
- [ ] Task 17.2: Create tests for ViewModels
- [ ] Task 17.3: Create tests for Repository implementations
- [ ] Task 17.4: Add test dependencies (JUnit, Mockito, etc.)
- [ ] Task 17.5: Ensure test coverage of happy path and error cases

## Deploy

1. Generate signed APK or AAB
2. Test on multiple devices

## TODO

NOTE: TODOs are not considered a STEP, and are not part of the regular workflow. Instead, they are meant to be done on demand only.

- [ ] Implement scrolling of only recent expenses section without scrolling entire screen
  - Allow users to scroll through expense list independently
  - Keep top sections (Daily Budget, Today's Summary, Month Summary) fixed at top
  - Better UX for browsing expenses without losing context
