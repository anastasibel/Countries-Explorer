package com.neanasta.core.ui.compose_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.neanasta.core.ui.theme.CountriesWorkmateTheme

@Composable
fun Screen(
    topTitle: String = "",
    navigateBack: (() -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar(
                title = topTitle,
                navigateBack = navigateBack,
            )
        },
        content = { padding ->
            Box(
                content = { content(padding) },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .navigationBarsPadding()
            .background(MaterialTheme.colorScheme.onSurfaceVariant)
            .statusBarsPadding()
    )
}

@Preview
@Composable
private fun Preview1() {
    CountriesWorkmateTheme() {
        Screen(
            topTitle = "Страны",
        ) {
            Text("Контент")
        }
    }
}

@Preview
@Composable
private fun Preview2() {
    CountriesWorkmateTheme {
        Screen(
            topTitle = "Страны",
            navigateBack = {}
        ) {
            Text("Контент")
        }
    }
}

@Preview
@Composable
private fun Preview3() {
    CountriesWorkmateTheme {
        Screen(
            navigateBack = {}
        ) {
            Text("Контент")
        }
    }
}