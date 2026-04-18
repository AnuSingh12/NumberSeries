package com.example.naturalnumbercounter

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.naturalnumbercounter.ui.navigation.FibonacciKey
import com.example.naturalnumbercounter.ui.navigation.PrimeKey
import com.example.naturalnumbercounter.ui.screen.fibonacciSeries.FibonacciScreen
import com.example.naturalnumbercounter.ui.screen.primeNumber.PrimeScreen

@Composable
fun Navigation() {

    val backStack = remember { mutableStateListOf<Any>(FibonacciKey) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->

            when (key) {

                is FibonacciKey -> NavEntry(key) {
                    FibonacciScreen(
                        onNextScreen = { backStack.add(PrimeKey) }
                    )
                }

                is PrimeKey -> NavEntry(key) {
                    PrimeScreen(
                        onBack = { backStack.add(FibonacciKey) }
                    )
                }

                else -> NavEntry(Unit) {
                    Text("Unknown")
                }
            }
        }
    )
}
