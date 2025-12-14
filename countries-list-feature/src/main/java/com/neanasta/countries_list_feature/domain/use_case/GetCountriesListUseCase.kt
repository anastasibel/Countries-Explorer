package com.neanasta.countries_list_feature.domain.use_case

import com.neanasta.countries_list_feature.domain.CountriesListRepository
import com.neanasta.countries_list_feature.domain.model.Country
import javax.inject.Inject

class GetCountriesListUseCase @Inject constructor(
    private val repository: CountriesListRepository,
) {
    suspend operator fun invoke(): Result {
        try {
            val response = repository.getCountriesListFromNetwork()
            repository.saveCountriesList(response)
            val local = repository.getCountriesListFromLocal()
            return Result.Success(local)
        } catch (e: Exception) {
            val local = repository.getCountriesListFromLocal()
            return Result.Error(e.message, local)
        }
    }

    sealed class Result() {
        data class Success(val list: List<Country>) : Result()
        data class Error(val message: String?, val list: List<Country>) : Result()
    }
}