package com.parkjin.music.di

import com.parkjin.music.core.data.repository.ContentRepositoryImpl
import com.parkjin.music.core.domain.repository.ContentRepository
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
    abstract fun bindsContentRepository(
        impl: ContentRepositoryImpl,
    ): ContentRepository
}
