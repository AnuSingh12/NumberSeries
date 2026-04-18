package com.example.naturalnumbercounter.ui.screen.primeNumber

import PrimeNumberViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.naturalnumbercounter.datastore.DataStore
import com.example.naturalnumbercounter.ui.component.PrimeNumberComponent

@Composable
fun PrimeScreen(
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val dataStore = DataStore(context)
    val viewmodel: PrimeNumberViewModel = viewModel(
        factory = PrimeNumberViewModelFactory(
            dataStore
        )
    )

    val numbers by viewmodel.numbers.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        PrimeNumberComponent(
            numbers = numbers,
            onClick = {
                viewmodel.onAddClick()
            },
            onBack = {
                onBack()
            }
        )
    }
}
