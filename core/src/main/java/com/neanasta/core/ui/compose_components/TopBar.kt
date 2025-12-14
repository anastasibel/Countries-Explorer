package com.neanasta.core.ui.compose_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neanasta.core.R
import com.neanasta.core.ui.theme.CountriesWorkmateTheme

@Composable
fun TopBar(
    title: String,
    navigateBack: (() -> Unit)? = null,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .height(48.dp)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        if (navigateBack != null) {
            Icon(
                painter = painterResource(R.drawable.ic_arrow_left),
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clip(CircleShape)
                    .clickable { navigateBack() }
                    .size(24.dp)
            )
        }
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    CountriesWorkmateTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            TopBar(
                title = "Страны",
            )
            TopBar(
                title = "Страны",
                navigateBack = {},
            )
        }
    }
}