package com.neanasta.core.room_data_base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.neanasta.core.room_data_base.entity.CountryEntity
import com.neanasta.core.room_data_base.entity.CountryEntity.Companion.TABLE_NAME

@Dao
interface CountriesDao {

    @Insert(onConflict = REPLACE)
    @JvmSuppressWildcards
    suspend fun saveCountriesList(countryEntities: List<CountryEntity>)

    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun loadCountriesList(): List<CountryEntity>
}