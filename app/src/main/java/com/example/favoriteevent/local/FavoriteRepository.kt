package com.example.favoriteevent.local

import android.content.Context
import kotlinx.coroutines.flow.Flow

object FavoriteRepository {
    private fun dao(context: Context) = AppDatabase.getInstance(context).favoriteDao()
    fun getAll(context: Context): Flow<List<FavoriteEventEntity>> = dao(context).getAllFavorites()
    suspend fun insert(context: Context, e: FavoriteEventEntity) = dao(context).insertFavorite(e)
    suspend fun deleteById(context: Context, eventId: Long) = dao(context).deleteFavoriteById(eventId)
    suspend fun isFavorite(context: Context, eventId: Long): Boolean = dao(context).isFavorite(eventId)
}