package com.example.favoriteevent.data

import com.example.favoriteevent.data.db.FavoriteEventEntity
import com.example.favoriteevent.data.models.EventDetailDto
import com.example.favoriteevent.data.models.EventDto
import kotlin.String

fun EventDto.toUi(): EventUi =
    EventUi(
        id = id,
        title = name ?: "(No Title)",
        shortDesc = when {
            !summary.isNullOrBlank() -> summary
            !description.isNullOrBlank() -> description
            else -> ""
        },
        image = if (!imageLogo.isNullOrBlank()) imageLogo else mediaCover,
        quota = quota
    )

fun EventDetailDto.toUI(): EventDetailUI =
    EventDetailUI(
        id = id,
        name = name,
        summary = summary,
        description = description,
        mediaCover = mediaCover,
        category = category,
        cityName = cityName,
        quota = quota,
    )

fun EventUi.toEntity() = FavoriteEventEntity(
    id = id,
    title = title,
    shortDesc = shortDesc,
    image = image,
    quota = quota
)

fun FavoriteEventEntity.toUi() = EventUi(
    id = id,
    title = title,
    shortDesc = shortDesc,
    image = image,
    quota = quota
)