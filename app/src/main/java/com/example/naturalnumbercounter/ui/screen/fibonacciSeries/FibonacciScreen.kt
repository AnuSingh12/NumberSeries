package com.example.naturalnumbercounter.ui.screen.fibonacciSeries

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.naturalnumbercounter.database.AppDatabase
import com.example.naturalnumbercounter.database.repository.NumberRepo
import com.example.naturalnumbercounter.ui.component.FibonacciComponent

@Composable
fun FibonacciScreen(
    onNextScreen: () -> Unit
) {
    val context = LocalContext.current
    val database = AppDatabase.getDatabase(context)
    val repository = NumberRepo(
        numberDao = database.numberDao(),
        primeNumberDao = database.primeNumberDao()
    )
    val viewmodel: FibonacciViewModel = viewModel(
        factory = FibonacciViewModelFactory(repository)
    )
    val numbers by viewmodel.fibonacci.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        FibonacciComponent(
            numbers = numbers,
            onClick = {
                viewmodel.onAddClick()
            },
            onNext = {
                onNextScreen()
            }
        )
    }
}
