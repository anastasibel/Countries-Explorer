package com.neanasta.countries_list_feature.data.local

import com.neanasta.core.room_data_base.dao.CountriesDao
import com.neanasta.countries_list_feature.domain.CountriesLocalDataSource
import com.neanasta.countries_list_feature.domain.model.Country
import javax.inject.Inject

class RoomCountriesDataSource @Inject constructor(val countriesDao: CountriesDao) :
    CountriesLocalDataSource {

    override suspend fun loadAllCountries(): List<Country> =
        countriesDao.loadCountriesList().map { it.toModel() }

    override suspend fun saveRemoteCountriesListResponse(response: List<Country>?) {
        val entities = response?.map { it.toEntity() }
        entities?.let {
            countriesDao.saveCountriesList(entities)
        }
    }
}