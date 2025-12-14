package com.neanasta.core.ui.compose_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neanasta.core.R
import com.neanasta.core.ui.theme.CountriesWorkmateTheme

@Composable
fun NoDataLayout(
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        Icon(
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(R.drawable.ic_no_data),
            contentDescription = null,
            tint = Color.Unspecified,
        )
        Text(
            text = stringResource(R.string.layout_text_error_no_data),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(12.dp, 16.dp, 12.dp, 0.dp)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    CountriesWorkmateTheme {
        NoDataLayout()
    }
}