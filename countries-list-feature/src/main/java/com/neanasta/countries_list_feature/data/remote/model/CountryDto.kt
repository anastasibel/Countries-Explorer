package com.neanasta.countries_list_feature.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryDto(
    @SerialName("flags") val flags: FlagsDto? = null,
    @SerialName("name") val name: NameDto? = null,
    @SerialName("currencies") val currencies: Map<String, CurrencyDetailsDto>? = null,
    @SerialName("capital") val capital: List<String>? = null,
    @SerialName("languages") val languages: Map<String, String>? = null,
    @SerialName("flag") val flag: String? = null,
    @SerialName("continents") val continents: List<String>? = null
)