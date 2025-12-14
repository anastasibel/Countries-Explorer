package com.neanasta.countries_list_feature.domain

import com.neanasta.countries_list_feature.domain.model.Country

interface CountriesRemoteDataSource {

    suspend fun getCountriesList(): List<Country>?
}