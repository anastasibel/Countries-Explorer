package com.neanasta.core.room_data_base

import android.content.Context
import androidx.room.Room
import com.neanasta.core.room_data_base.dao.CountriesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): CountriesDataBase =
        Room.databaseBuilder(
            context,
            CountriesDataBase::class.java,
            "countries_db"
        ).build()

    @Provides
    @Singleton
    fun provideDao(dataBase: CountriesDataBase): CountriesDao = dataBase.countriesDao()
}