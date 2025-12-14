package com.neanasta.countries_list_feature.presentation

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
sealed class CountriesNavigationRoute {

    @Serializable
    data object CountriesList : CountriesNavigationRoute()

    @Serializable
    data object CountryDetails : CountriesNavigationRoute()
}