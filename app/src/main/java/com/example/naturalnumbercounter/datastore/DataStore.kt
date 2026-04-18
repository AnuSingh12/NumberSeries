package com.example.naturalnumbercounter.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "datastore_series")

class DataStore(private val context: Context) {
    companion object {
        val SERIES_KEY = stringSetPreferencesKey("prime_list")
    }

    fun readSeries(): Flow<List<Int>> = context.dataStore.data.map { preferences ->
        preferences[SERIES_KEY]
            ?.map { it.toInt() }
            ?.sortedDescending()
            ?: emptyList()
    }

    suspend fun writeSeries(value: Int) {
        context.dataStore.edit { preferences ->
            val currentList = preferences[SERIES_KEY] ?: emptySet()
            val updatedList = currentList + value.toString()
            preferences[SERIES_KEY] = updatedList
        }
    }
}




