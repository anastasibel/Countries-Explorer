package com.neanasta.countries_list_feature.presentation.countries_list

import androidx.lifecycle.viewModelScope
import com.neanasta.core.base_mvi.BaseViewModel
import com.neanasta.countries_list_feature.domain.model.Country
import com.neanasta.countries_list_feature.domain.use_case.GetCountriesListUseCase
import com.neanasta.countries_list_feature.presentation.countries_list.CountriesListContract.Action
import com.neanasta.countries_list_feature.presentation.countries_list.CountriesListContract.Effect
import com.neanasta.countries_list_feature.presentation.countries_list.CountriesListContract.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesListViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesListUseCase
) : BaseViewModel<State, Action, Effect>() {
    override fun createInitialState() = State()

    override fun handleAction(action: Action) {
        when (action) {
            is Action.LoadCountries -> getCountriesList()
            is Action.SetError -> handleError(action.error, currentState.countries)
            is Action.OnCountryClick -> setEffect { Effect.NavigateToDetails(action.country) }
        }
    }

    private fun getCountriesList() {
        viewModelScope.launch {
            updateState { it.copy(loading = true, error = null) }
            when (val result = getCountriesUseCase()) {
                is GetCountriesListUseCase.Result.Error -> handleError(result.message, result.list)
                is GetCountriesListUseCase.Result.Success -> handleCountriesList(result.list)
            }
        }
    }

    private fun handleError(message: String?, list: List<Country>) {
        updateState { it.copy(error = message, loading = false, countries = list) }
    }

    private fun handleCountriesList(list: List<Country>?) {
        updateState {
            it.copy(
                countries = list ?: emptyList(), loading = false
            )
        }
    }
}