package com.neanasta.core.retrofit

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

internal fun OkHttpClient.Builder.addTimeout(timeout: Long = 60L): OkHttpClient.Builder {

    readTimeout(timeout, TimeUnit.SECONDS)
        .writeTimeout(timeout, TimeUnit.SECONDS)
        .connectTimeout(timeout, TimeUnit.SECONDS)
    return this
}