package com.parkjin.music.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.parkjin.music.core.data.local.dao.ArchivedContentDao
import com.parkjin.music.core.data.local.entity.ArchivedContentEntity

@Database(
    version = 1,
    entities = [ArchivedContentEntity::class],
    exportSchema = false,
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun archivedContentDao(): ArchivedContentDao
}
