package com.parkjin.music.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.parkjin.music.core.data.api.SearchApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideRetrofit(json: Json): Retrofit {
        val factory = json.asConverterFactory("application/json".toMediaType())
        val client = OkHttpClient.Builder().build()

        return Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(factory)
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideSearchApi(retrofit: Retrofit): SearchApi {
        return retrofit.create(SearchApi::class.java)
    }
}
