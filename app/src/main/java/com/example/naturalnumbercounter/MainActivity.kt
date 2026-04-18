package com.example.naturalnumbercounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.naturalnumbercounter.ui.theme.NaturalNumberCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NaturalNumberCounterTheme {
                Navigation()
            }
        }
    }
}

