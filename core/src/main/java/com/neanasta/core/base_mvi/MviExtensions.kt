package com.neanasta.core.base_mvi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow

@Composable
fun <E : MviEffect> MviEffectResolver(
    flow: Flow<E>,
    block: (E) -> Unit,
) {

    val lifecycle = LocalLifecycleOwner.current
    LaunchedEffect(flow) {
        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collect { block(it) }
        }
    }
}