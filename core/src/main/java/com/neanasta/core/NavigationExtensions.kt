package com.neanasta.core

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder

fun <T> NavController.navigateWithArg(
    route: Any,
    key: String,
    args: T?,
    builder: NavOptionsBuilder.() -> Unit = {}
) {

    this.currentBackStackEntry?.savedStateHandle?.set(key, args)
    navigate(route, builder)
}

fun <T> NavController.getArg(
    key: String,
): T? {

    val args = this.previousBackStackEntry
        ?.savedStateHandle
        ?.get<T>(key)
    return args
}