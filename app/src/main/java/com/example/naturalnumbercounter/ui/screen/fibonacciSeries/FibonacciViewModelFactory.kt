package com.example.naturalnumbercounter.ui.screen.fibonacciSeries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.naturalnumbercounter.database.repository.NumberRepo

class FibonacciViewModelFactory(
    private val repository: NumberRepo
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FibonacciViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FibonacciViewModel(
                repository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}