package com.neanasta.core.room_data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.neanasta.core.room_data_base.dao.CountriesDao
import com.neanasta.core.room_data_base.entity.CountryEntity

@Database(entities = [CountryEntity::class], version = 3, exportSchema = true)
abstract class CountriesDataBase : RoomDatabase() {

    abstract fun countriesDao(): CountriesDao
}