package com.neanasta.countries_list_feature.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NameDto(
    @SerialName("common") val common: String? = null,
    @SerialName("official") val official: String? = null,
)