package com.example.favoriteevent.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorites ORDER BY id DESC")
    fun getAllFavorites(): Flow<List<FavoriteEventEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(favorite: FavoriteEventEntity)

    @Query("DELETE FROM favorites WHERE id = :eventId")
    fun deleteFavorite(eventId: Long)

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE id = :eventId)")
    fun isFavorite(eventId: Long): Boolean
}