package com.parkjin.music.di

import android.app.Application
import androidx.room.Room
import com.parkjin.music.core.data.local.LocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application) =
        Room.databaseBuilder(application, LocalDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideArchivedContentDao(database: LocalDatabase) = database.archivedContentDao()
}
