package com.example.naturalnumbercounter.ui.screen.primeNumber

import PrimeNumberViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.naturalnumbercounter.datastore.DataStore

class PrimeNumberViewModelFactory(
    private val dataStoreSeries: DataStore
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PrimeNumberViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PrimeNumberViewModel(
                dataStoreSeries
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}