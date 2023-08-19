package com.parkjin.music.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.parkjin.music.core.data.local.dao.ContentDao
import com.parkjin.music.core.data.local.entity.ContentEntity

@Database(
    version = 1,
    entities = [ContentEntity::class],
    exportSchema = false,
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun contentDao(): ContentDao
}
