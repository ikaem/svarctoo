# An app for tracking my expenses and budget.

# Android Compose App Creation Steps

## Git Workflow

- Create one branch per step with descriptive names (e.g., `feature/step-1-project-structure`, `feature/step-2-models-and-data`)
- Branch from `master` for each step
- After completing each subtask, mark it as done in this file and commit immediately
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
- [ ] Task 3.4: Build Section 3 - Current month summary
  - Show total spent this month
  - Show total remainder for month
  - Show total budget for month
- [ ] Task 3.5: Build Section 4 - Latest expenses list
  - Display recent expenses in brief format
  - Show amount, description, and date

## Step 4: Render HomeScreen in MainActivity

- [ ] Task 4.1: Update MainActivity to display the HomeScreen composable
  - Import HomeScreen composable
  - Set HomeScreen as the content of the main composable function
  - Verify HomeScreen renders when app starts

## Step 5: Create Theme & Styling

- [ ] Task 5.1: Define color scheme
- [ ] Task 5.2: Define typography
- [ ] Task 5.3: Apply theme to all composables

## Step 6: Build and Test

1. Sync Gradle
2. Build the project
3. Run on emulator or device
4. Verify all UI sections render correctly with dummy data

## Step 7: Deploy

1. Generate signed APK or AAB
2. Test on multiple devices
