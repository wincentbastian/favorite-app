package com.example.favoriteevent.data

import com.example.favoriteevent.local.FavoriteEventEntity

fun EventUi.toEntity() = FavoriteEventEntity(
    id = id,
    title = title,
    shortDesc = shortDesc,
    image = image
)

fun FavoriteEventEntity.toUi() = EventUi(
    id = id,
    title = title,
    shortDesc = shortDesc,
    image = image,
)