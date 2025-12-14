package com.neanasta.countries_list_feature.presentation.country_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.neanasta.core.ui.compose_components.NoDataLayout
import com.neanasta.core.ui.compose_components.Screen
import com.neanasta.countries_list_feature.R
import com.neanasta.countries_list_feature.domain.model.Country

@Composable
fun CountryDetailsScreen(
    country: Country?,
    navigateBack: () -> Unit
) {
    if (country == null) {
        NoDataLayout()
    } else {
        ScreenContent(
            country = country,
            navigateBack = navigateBack
        )
    }
}

@Composable
fun ScreenContent(country: Country, navigateBack: () -> Unit) {
    Screen(
        navigateBack = navigateBack
    ) {
        Column(Modifier.fillMaxSize()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                AsyncImage(
                    model = country.imageFlag,
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                country.name?.let {
                    Text(
                        text = it,
                        fontSize = 16.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            InfoField(stringResource(R.string.continent), country.continent)
            InfoField(stringResource(R.string.capital), country.capital)
            InfoField(stringResource(R.string.language), country.language)
            val currencyText =
                "${country.currencyName ?: ""} ${country.currencySymbol ?: ""}".trim()
            if (currencyText.isNotBlank()) {
                InfoField(stringResource(R.string.currency), currencyText)
            }
            country.emojiFlag?.let { emoji ->
                InfoField("Other details", "Emoji flag $emoji")
            }
        }
    }
}

@Composable
fun InfoField(label: String, value: String?) {
    value?.let {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(text = label)
            Spacer(Modifier.height(4.dp))
            Box(
                Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = value)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ScreenContent(
        country = Country(
            imageFlag = null,
            name = "Poland",
            currencyName = "Polish złoty",
            currencySymbol = "zł",
            capital = "Warsaw",
            language = "Polish",
            emojiFlag = "🇵🇱",
            continent = "Europe"
        ),
        navigateBack = {})
}