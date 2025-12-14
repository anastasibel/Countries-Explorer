package com.neanasta.countries_list_feature.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FlagsDto(
    @SerialName("png") val png: String? = null,
    @SerialName("svg") val svg: String? = null,
    @SerialName("alt") val alt: String? = null
)