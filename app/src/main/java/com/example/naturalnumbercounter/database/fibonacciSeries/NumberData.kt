package com.example.naturalnumbercounter.database.fibonacciSeries

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "numbers")
data class NumberData (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val value: Long
)