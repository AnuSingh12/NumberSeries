package com.example.naturalnumbercounter.database.primeNumber

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prime_numbers")
data class PrimeNumber(
    @PrimaryKey
    val value: Int
)
