package com.neanasta.core.retrofit

import android.content.Context
import android.util.Log
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.neanasta.core.R
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Inject

class RetrofitFactory @Inject constructor(
    context: Context,
) {

    private val baseUrl: String = context.getString(R.string.base_url)
    private val timeout: Long = TIMEOUT

    private val contentType: MediaType = "application/json".toMediaType()

    private fun json(): Json = Json {
        isLenient = true
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    private fun loggerInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun client(): OkHttpClient.Builder = OkHttpClient.Builder()
        .addInterceptor(loggerInterceptor())
        .addTimeout(timeout)

    fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client().build())
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(json().asConverterFactory(contentType))
        .build()

    companion object {
        private const val TIMEOUT = 30L
    }
}