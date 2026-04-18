# Number Series App

An Android application that generates number sequences using modern Android architecture.

## Features

### Fibonacci Screen
- Displays Fibonacci series
- Data stored using **Room Database**
- Two buttons:
  Add → generates next Fibonacci number
  Next → navigates to Prime screen

### Prime Number Screen
- Displays Prime numbers in **descending order (starting from 997)**
- Data handled using **DataStore**
- Two buttons:
  Back → returns to Fibonacci screen
  Add → generates next prime number

## Architecture & Tech

- Kotlin
- MVVM Architecture
- Jetpack Compose UI
- Navigation 3
- Room Database (Fibonacci)
- DataStore (Prime numbers)
- StateFlow & Coroutines
