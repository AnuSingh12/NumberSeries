package com.example.naturalnumbercounter.database.repository

import com.example.naturalnumbercounter.database.fibonacciSeries.NumberDao
import com.example.naturalnumbercounter.database.fibonacciSeries.NumberData
import com.example.naturalnumbercounter.database.primeNumber.PrimeNumber
import com.example.naturalnumbercounter.database.primeNumber.PrimeNumberDao

class NumberRepo(
    private val numberDao: NumberDao,
    private val primeNumberDao: PrimeNumberDao
) {
    fun getFibonacci() = numberDao.getFibonacci()

    suspend fun insertNumberForSeries(value: Long) {
        numberDao.insertNumberForFibonacci(NumberData(value = value))
    }

    fun getAllPrime() = primeNumberDao.getAllPrime()

    suspend fun getLastPrime() = primeNumberDao.getLastPrime()

    suspend fun insertPrime(value: Int) {
        primeNumberDao.insert(PrimeNumber(value = value))
    }
}
