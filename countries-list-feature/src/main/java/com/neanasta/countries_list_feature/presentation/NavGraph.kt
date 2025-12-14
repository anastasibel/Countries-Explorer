package com.neanasta.countries_list_feature.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.neanasta.core.getArg
import com.neanasta.core.navigateWithArg
import com.neanasta.countries_list_feature.domain.model.Country
import com.neanasta.countries_list_feature.presentation.countries_list.CountriesListScreen
import com.neanasta.countries_list_feature.presentation.country_details.CountryDetailsScreen

fun NavGraphBuilder.countriesListNavGraph(navController: NavHostController) {

    composable<CountriesNavigationRoute.CountriesList> {
        CountriesListScreen(
            navigateToDetails = { country ->
                navController.navigateWithArg(
                    route = CountriesNavigationRoute.CountryDetails,
                    key = COUNTRY,
                    args = country,
                )
            }
        )
    }

    composable<CountriesNavigationRoute.CountryDetails> {
        val country = navController.getArg<Country>(COUNTRY)
        country?.let {
            CountryDetailsScreen(
                country = country,
                navigateBack = navController::popBackStack
            )
        }
    }
}