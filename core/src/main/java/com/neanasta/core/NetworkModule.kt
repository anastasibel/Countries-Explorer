package com.neanasta.core

import android.content.Context
import com.neanasta.core.retrofit.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit(
        @ApplicationContext context: Context,
    ): Retrofit {
        return RetrofitFactory(context).retrofit()
    }
}