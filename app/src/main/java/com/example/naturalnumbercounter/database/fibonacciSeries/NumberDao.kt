package com.example.naturalnumbercounter.database.fibonacciSeries

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NumberDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNumberForFibonacci(number: NumberData)
    @Query("SELECT * FROM numbers ORDER BY id ASC")
    fun getFibonacci(): Flow<List<NumberData>>

}