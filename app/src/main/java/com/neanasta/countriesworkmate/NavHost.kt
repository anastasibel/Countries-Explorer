package com.neanasta.countriesworkmate

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.neanasta.countries_list_feature.presentation.CountriesNavigationRoute
import com.neanasta.countries_list_feature.presentation.countriesListNavGraph

@Composable
fun NavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = CountriesNavigationRoute.CountriesList,
        enterTransition = { fadeIn(animationSpec = tween(500)) },
        exitTransition = { fadeOut(animationSpec = tween(500)) },
        popEnterTransition = { fadeIn(animationSpec = tween(500)) },
        popExitTransition = { fadeOut(animationSpec = tween(500)) }
    ) {

        countriesListNavGraph(navHostController)
    }
}