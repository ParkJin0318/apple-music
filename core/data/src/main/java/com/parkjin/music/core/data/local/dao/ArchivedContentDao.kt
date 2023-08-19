package com.parkjin.music.core.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.parkjin.music.core.data.local.entity.ArchivedContentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArchivedContentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContent(entity: ArchivedContentEntity)

    @Query("SELECT * FROM content_table")
    fun getContents(): Flow<List<ArchivedContentEntity>>

    @Delete
    suspend fun deleteContent(entity: ArchivedContentEntity)
}
