package com.neanasta.countries_list_feature.presentation.countries_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.neanasta.core.base_mvi.MviEffectResolver
import com.neanasta.core.loadBitmapFromUrl
import com.neanasta.core.ui.compose_components.DialogMessage
import com.neanasta.core.ui.compose_components.LoaderFullScreen
import com.neanasta.core.ui.compose_components.NoDataLayout
import com.neanasta.core.ui.compose_components.Screen
import com.neanasta.core.urlToByteArray
import com.neanasta.countries_list_feature.R
import com.neanasta.countries_list_feature.domain.model.Country
import com.neanasta.countries_list_feature.presentation.countries_list.CountriesListContract.Action
import com.neanasta.countries_list_feature.presentation.countries_list.CountriesListContract.State

@Composable
fun CountriesListScreen(
    viewModel: CountriesListViewModel = hiltViewModel(),
    navigateToDetails: (Country) -> Unit,
) {
    val state by viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.setAction(Action.LoadCountries)
    }
    MviEffectResolver(viewModel.effect) { effect ->
        when (effect) {
            is CountriesListContract.Effect.NavigateToDetails -> navigateToDetails(effect.country)
        }
    }
    ScreenContent(
        state = state,
        onAction = viewModel::setAction
    )
}

@Composable
private fun ScreenContent(
    state: State,
    onAction: (Action) -> Unit
) {
    Screen(
        topTitle = stringResource(R.string.countries_title)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            if (state.countries.isEmpty() && !state.loading) {
                NoDataLayout()
            } else {
                LazyColumn {
                    items(state.countries) { country ->
                        CountryItem(
                            country = country,
                            onCountryClick = { onAction(Action.OnCountryClick(it)) }
                        )
                    }
                }
            }
            LoaderFullScreen(state.loading)
            state.error?.let { text ->
                DialogMessage(
                    message = text,
                    onLeftBtnClick = { onAction(Action.LoadCountries) },
                    onRightBtnClick = { onAction(Action.SetError(null)) },
                )
            }
        }
    }
}

@Composable
private fun CountryItem(
    country: Country,
    onCountryClick: (Country) -> Unit
) {
    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable { onCountryClick(country) }
    ) {
        AsyncImage(
            model = country.imageFlag,
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))
        country.name?.let {
            Text(
                text = it,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview1() {
    val countriesExample = listOf(
        Country(name = "Germany"),
        Country(name = "Russia"),
        Country(name = "Japan")
    )
    ScreenContent(
        state = State(countries = countriesExample),
        onAction = {}
    )
}

@Preview(showBackground = true)
@Composable
fun Preview2() {
    ScreenContent(
        state = State(error = "Error"),
        onAction = {}
    )
}