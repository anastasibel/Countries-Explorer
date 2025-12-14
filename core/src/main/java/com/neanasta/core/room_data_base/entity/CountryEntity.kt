package com.neanasta.core.room_data_base.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.neanasta.core.room_data_base.entity.CountryEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CountryEntity(
    val imageFlag: String? = null,
    val currencyName: String? = null,
    val currencySymbol: String? = null,
    val capital: String? = null,
    val mainLanguage: String? = null,
    val emojiFlag: String? = null,
    val continent: String? = null,
    @PrimaryKey
    val name: String,
) {
    companion object {
        const val TABLE_NAME = "country_table"
    }
}