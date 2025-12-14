package com.neanasta.countries_list_feature.domain

import com.neanasta.countries_list_feature.domain.model.Country

interface CountriesLocalDataSource {

    suspend fun loadAllCountries(): List<Country>

    suspend fun saveRemoteCountriesListResponse(response: List<Country>?)
}