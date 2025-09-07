package com.example.favoriteevent.data

fun EventDto.toUi(): EventUi =
    EventUi(
        id = id,
        title = name ?: "(No Title)",
        shortDesc = when {
            !summary.isNullOrBlank() -> summary
            !description.isNullOrBlank() -> description
            else -> ""
        },
        image = if (!imageLogo.isNullOrBlank()) imageLogo else mediaCover
    )