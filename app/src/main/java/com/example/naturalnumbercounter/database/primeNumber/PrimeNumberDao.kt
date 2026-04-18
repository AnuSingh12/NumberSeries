package com.example.naturalnumbercounter.database.primeNumber

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PrimeNumberDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(prime: PrimeNumber)

    @Query("SELECT * FROM prime_numbers ORDER BY value DESC")
    fun getAllPrime(): Flow<List<PrimeNumber>>

    @Query("SELECT * FROM prime_numbers ORDER BY value DESC LIMIT 1")
    suspend fun getLastPrime(): PrimeNumber?
}
