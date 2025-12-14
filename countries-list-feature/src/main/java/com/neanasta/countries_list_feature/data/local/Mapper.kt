package com.neanasta.countries_list_feature.data.local

import com.neanasta.core.room_data_base.entity.CountryEntity
import com.neanasta.countries_list_feature.domain.model.Country

fun CountryEntity.toModel(): Country = Country(
    imageFlag = imageFlag?.decodeToString(),
    name = name,
    currencyName = currencyName,
    currencySymbol = currencySymbol,
    capital = capital,
    language = mainLanguage,
    emojiFlag = emojiFlag,
    continent = continent
)

fun Country.toEntity() = CountryEntity(
    imageFlag = imageFlag?.toByteArray(),
    currencyName = currencyName,
    currencySymbol = currencySymbol,
    capital = capital,
    mainLanguage = language,
    emojiFlag = emojiFlag,
    continent = continent,
    name = name.orEmpty()
)