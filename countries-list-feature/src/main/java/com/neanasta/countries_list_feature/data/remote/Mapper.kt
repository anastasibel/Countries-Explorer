package com.neanasta.countries_list_feature.data.remote

import com.neanasta.countries_list_feature.data.remote.model.CountryDto
import com.neanasta.countries_list_feature.domain.model.Country

fun CountryDto.toModel() = Country(
    imageFlag = flags?.png,
    name = name?.common,
    currencyName = currencies?.values?.firstOrNull()?.name,
    currencySymbol = currencies?.values?.firstOrNull()?.symbol,
    capital = capital?.firstOrNull(),
    language = languages?.values?.firstOrNull(),
    emojiFlag = flag,
    continent = continents?.firstOrNull()
)