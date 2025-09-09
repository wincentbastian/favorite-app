package com.example.favoriteevent.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity(tableName = "favorites")
data class FavoriteEventEntity(
    @PrimaryKey val id: Long,
    val title: String,
    val shortDesc: String,
    val image: String?,
    val quota: String?,
    val registrants: String
)