package com.neanasta.core.room_data_base.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.neanasta.core.room_data_base.entity.CountryEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CountryEntity(
    val imageFlag: ByteArray? = null,
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CountryEntity

        if (!(imageFlag?.contentEquals(other.imageFlag) ?: (other.imageFlag == null))) return false
        if (currencyName != other.currencyName) return false
        if (currencySymbol != other.currencySymbol) return false
        if (capital != other.capital) return false
        if (mainLanguage != other.mainLanguage) return false
        if (emojiFlag != other.emojiFlag) return false
        if (continent != other.continent) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = imageFlag?.contentHashCode() ?: 0
        result = 31 * result + (currencyName?.hashCode() ?: 0)
        result = 31 * result + (currencySymbol?.hashCode() ?: 0)
        result = 31 * result + (capital?.hashCode() ?: 0)
        result = 31 * result + (mainLanguage?.hashCode() ?: 0)
        result = 31 * result + (emojiFlag?.hashCode() ?: 0)
        result = 31 * result + (continent?.hashCode() ?: 0)
        result = 31 * result + (name.hashCode())
        return result
    }
}