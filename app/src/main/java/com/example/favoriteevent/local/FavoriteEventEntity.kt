package com.example.favoriteevent.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteEventEntity(
    @PrimaryKey val id: Long,
    val title: String,
    val shortDesc: String,
    val image: String?,
)