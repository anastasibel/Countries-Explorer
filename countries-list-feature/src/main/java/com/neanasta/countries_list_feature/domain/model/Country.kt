package com.neanasta.countries_list_feature.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val imageFlag: String? = null,
    val name: String? = null,
    val currencyName: String? = null,
    val currencySymbol: String? = null,
    val capital: String? = null,
    val language: String? = null,
    val emojiFlag: String? = null,
    val continent: String? = null,
) : Parcelable