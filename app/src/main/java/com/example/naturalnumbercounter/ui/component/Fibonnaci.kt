package com.example.naturalnumbercounter.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.naturalnumbercounter.database.fibonacciSeries.NumberData

@Composable
fun FibonacciComponent(
    numbers: List<NumberData>,
    onClick: () -> Unit,
    onNext:() -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(12.dp)
        ) {
            items(numbers) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(MaterialTheme.colorScheme.tertiary.copy(0.08f)),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Your number is: ${item.value}",
                        modifier = Modifier.padding(vertical = 12.dp)
                    )
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { onClick() },
                modifier = Modifier
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    contentColor = MaterialTheme.colorScheme.error
                )
            ) {
                Text(
                    text = "Next"
                )
            }
            Button(
                onClick = { onNext() },
                modifier = Modifier
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    contentColor = MaterialTheme.colorScheme.error
                )
            ) {
                Text(
                    text = "Go to Screen 2"
                )
            }
        }
    }
}
