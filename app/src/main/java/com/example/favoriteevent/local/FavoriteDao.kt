package com.example.favoriteevent.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.favoriteevent.data.db.FavoriteEventEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorites ORDER BY id DESC")
    fun getAllFavorites(): Flow<List<FavoriteEventEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: FavoriteEventEntity)

    @Query("DELETE FROM favorites WHERE id = :eventId")
    suspend fun deleteFavoriteById(eventId: Long)

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE id = :eventId)")
    suspend fun isFavorite(eventId: Long): Boolean
}