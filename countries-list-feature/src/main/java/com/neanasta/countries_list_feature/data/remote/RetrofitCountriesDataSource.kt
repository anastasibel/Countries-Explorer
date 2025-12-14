package com.neanasta.countries_list_feature.data.remote

import com.neanasta.countries_list_feature.domain.CountriesRemoteDataSource
import com.neanasta.countries_list_feature.domain.model.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RetrofitCountriesDataSource @Inject constructor(
    private val countriesApi: CountriesApi,
) : CountriesRemoteDataSource {
    override suspend fun getCountriesList(): List<Country>? = withContext(Dispatchers.IO) {
        val response = countriesApi.getCountriesList()
        if (response.isSuccessful) {
            response.body()?.map { it.toModel() }
        } else {
            throw Exception(response.message())
        }
    }
}