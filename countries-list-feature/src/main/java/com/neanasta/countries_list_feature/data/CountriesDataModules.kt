package com.neanasta.countries_list_feature.data

import com.neanasta.core.room_data_base.CountriesDataBase
import com.neanasta.countries_list_feature.domain.CountriesListRepository
import com.neanasta.countries_list_feature.data.local.RoomCountriesDataSource
import com.neanasta.countries_list_feature.data.remote.CountriesApi
import com.neanasta.countries_list_feature.data.remote.RetrofitCountriesDataSource
import com.neanasta.countries_list_feature.domain.CountriesLocalDataSource
import com.neanasta.countries_list_feature.domain.CountriesRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CountriesBindsModule {

    @Binds
    @Singleton
    fun bindRemoteDataSource(impl: RetrofitCountriesDataSource): CountriesRemoteDataSource

    @Binds
    @Singleton
    fun bindRepository(impl: CountriesListRepositoryImpl): CountriesListRepository
}

@Module
@InstallIn(SingletonComponent::class)
object CountriesProvidesModule {

    @Provides
    @Singleton
    fun provideCountriesApi(retrofit: Retrofit): CountriesApi =
        retrofit.create(CountriesApi::class.java)

    @Provides
    @Singleton
    fun provideLocalDataSource(dataBase: CountriesDataBase): CountriesLocalDataSource = RoomCountriesDataSource(dataBase.countriesDao())
}