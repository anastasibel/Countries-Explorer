package com.neanasta.core.ui.compose_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neanasta.core.ui.theme.CountriesWorkmateTheme
import com.neanasta.core.ui.theme.circle

@Composable
fun LoaderFullScreen(
    visible: Boolean,
    modifier: Modifier = Modifier,
) {
    if (!visible) return
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        CircularLoader()
    }
}

@Composable
private fun CircularLoader(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(24.dp)
            .clip(MaterialTheme.shapes.circle)
            .background(MaterialTheme.colorScheme.background)
            .size(48.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                strokeWidth = 3.dp,
                strokeCap = StrokeCap.Round,
                modifier = modifier.size(24.dp)
            )
        }
    }
}

@Preview
@Composable
private fun LoaderFullScreenPreview() {
    CountriesWorkmateTheme {
        LoaderFullScreen(true)
    }
}