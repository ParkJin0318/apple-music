package com.parkjin.music.core.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.parkjin.music.core.data.api.SearchAPI
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
    fun provideGithubApi(json: Json): SearchAPI {
        val factory = json.asConverterFactory("application/json".toMediaType())
        val client = OkHttpClient.Builder().build()

        return Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(factory)
            .client(client)
            .build()
            .create(SearchAPI::class.java)
    }
}
