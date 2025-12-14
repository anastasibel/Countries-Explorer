package com.neanasta.countries_list_feature.data.remote

import com.neanasta.countries_list_feature.data.remote.model.CountryDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CountriesApi {

    @GET("all")
    suspend fun getCountriesList(
        @Query("fields") fields: String = "languages,capital,flags,name,currencies,flag,continents"
    ): Response<List<CountryDto>?>
}