package com.example.naturalnumbercounter.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.naturalnumbercounter.database.fibonacciSeries.NumberDao
import com.example.naturalnumbercounter.database.fibonacciSeries.NumberData
import com.example.naturalnumbercounter.database.primeNumber.PrimeNumber
import com.example.naturalnumbercounter.database.primeNumber.PrimeNumberDao

@Database(
    entities = [
        NumberData::class,
        PrimeNumber::class
    ],
    version = 5
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun numberDao(): NumberDao

    abstract fun primeNumberDao(): PrimeNumberDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "number_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}
