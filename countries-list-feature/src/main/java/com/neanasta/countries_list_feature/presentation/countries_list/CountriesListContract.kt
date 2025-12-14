package com.neanasta.countries_list_feature.presentation.countries_list

import com.neanasta.core.base_mvi.MviAction
import com.neanasta.core.base_mvi.MviEffect
import com.neanasta.core.base_mvi.MviState
import com.neanasta.countries_list_feature.domain.model.Country

object CountriesListContract {

    sealed interface Action : MviAction {
        object LoadCountries : Action
        data class SetError(val error: String?) : Action
        data class OnCountryClick(val country: Country) : Action
    }

    sealed interface Effect : MviEffect {
        data class NavigateToDetails(val country: Country) : Effect
    }

    data class State(
        val countries: List<Country> = emptyList(),
        val loading: Boolean = false,
        val error: String? = null
    ) : MviState
}