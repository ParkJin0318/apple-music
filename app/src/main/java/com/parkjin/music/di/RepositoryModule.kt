package com.parkjin.music.di

import com.parkjin.music.core.data.repository.SearchRepositoryImpl
import com.parkjin.music.core.domain.repository.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsSearchRepository(
        impl: SearchRepositoryImpl,
    ): SearchRepository
}
