package com.example.naturalnumbercounter.ui.screen.fibonacciSeries

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naturalnumbercounter.database.fibonacciSeries.NumberData
import com.example.naturalnumbercounter.database.repository.NumberRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

//class FibonacciViewModel(
//    private val repository: NumberRepo
//) : ViewModel() {
//    companion object {
//        private const val TAG = "number_vm"
//    }
//
//    private val _fibonacci = MutableStateFlow<List<NumberData>>(emptyList())
//    val fibonacci = _fibonacci.asStateFlow()
//
//    fun readNumbers() {
//        viewModelScope.launch {
//            repository.getFibonacci().collect { data ->
//                _fibonacci.value = data
//                Log.d(TAG, "$data")
//            }
//        }
//    }
//
//    fun onAddClick() {
//        viewModelScope.launch {
//
//            val list = _fibonacci.value
//
//            val next = when (list.size) {
//                0 -> 0L
//                1 -> 1L
//                else -> {
//                    list[list.size - 1].value + list[list.size - 2].value
//                }
//            }
//            repository.insertNumberForSeries(next)
//        }
//    }
//
//    init {
//        readNumbers()
//    }
//}



class FibonacciViewModel(
    private val repository: NumberRepo
) : ViewModel() {

    val fibonacci = repository.getFibonacci()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun onAddClick() {
        viewModelScope.launch {

            val list = repository.getFibonacci().first()

            val next = when (list.size) {
                0 -> 0L
                1 -> 1L
                else -> list.takeLast(2).let { it[0].value + it[1].value }
            }

            repository.insertNumberForSeries(next)
        }
    }
}


