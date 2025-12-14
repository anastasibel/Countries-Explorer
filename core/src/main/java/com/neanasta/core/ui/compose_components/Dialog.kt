package com.neanasta.core.ui.compose_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.neanasta.core.R

@Composable
fun DialogMessage(
    message: String,
    onLeftBtnClick: () -> Unit,
    onRightBtnClick: () -> Unit,
    rightBtnText: String = "",
    leftBtnText: String = "",
) {
    if (message.isBlank()) return
    val okText = stringResource(R.string.dialog_ok)
    val retryText = stringResource(R.string.dialog_retry)
    val rightContent by remember { mutableStateOf(rightBtnText.ifBlank { okText }) }
    val leftContent by remember { mutableStateOf(leftBtnText.ifBlank { retryText }) }

    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.small)
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = MaterialTheme.shapes.small
                )
        ) {
            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
            )
            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(10.dp, 30.dp, 10.dp, 8.dp)
            ) {
                TextButton(
                    onClick = onLeftBtnClick,
                    modifier = Modifier.padding(end = 8.dp),
                    content = { Text(text = leftContent) }
                )
                TextButton(
                    content = { Text(text = rightContent) },
                    onClick = onRightBtnClick,
                )
            }
        }
    }
}

@Composable
@Preview
private fun Preview1() {
    DialogMessage(
        message = "Сообщение об ошибке",
        onLeftBtnClick = {},
        onRightBtnClick = {},
    )
}