package com.neanasta.countries_list_feature.domain

import com.neanasta.countries_list_feature.domain.model.Country

interface CountriesListRepository {

    suspend fun getCountriesListFromNetwork(): List<Country>?
    suspend fun getCountriesListFromLocal(): List<Country>
    suspend fun saveCountriesList(list: List<Country>?)
}