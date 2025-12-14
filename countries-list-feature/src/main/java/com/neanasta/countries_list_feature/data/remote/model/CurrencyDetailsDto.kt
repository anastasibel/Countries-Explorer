package com.neanasta.countries_list_feature.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyDetailsDto(
    @SerialName("name") val name: String? = null,
    @SerialName("symbol") val symbol: String? = null
)