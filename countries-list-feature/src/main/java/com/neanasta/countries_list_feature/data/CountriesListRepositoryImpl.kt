package com.neanasta.countries_list_feature.data

import com.neanasta.countries_list_feature.domain.CountriesListRepository
import com.neanasta.countries_list_feature.domain.CountriesLocalDataSource
import com.neanasta.countries_list_feature.domain.CountriesRemoteDataSource
import com.neanasta.countries_list_feature.domain.model.Country
import javax.inject.Inject

class CountriesListRepositoryImpl @Inject constructor(
    private val remoteDataSource: CountriesRemoteDataSource,
    private val localDataSource: CountriesLocalDataSource,
) : CountriesListRepository {

    override suspend fun getCountriesListFromNetwork(): List<Country>? {
        return remoteDataSource.getCountriesList()
    }

    override suspend fun getCountriesListFromLocal(): List<Country> {
        return localDataSource.loadAllCountries()
    }

    override suspend fun saveCountriesList(list: List<Country>?) {
        localDataSource.saveRemoteCountriesListResponse(list)
    }
}