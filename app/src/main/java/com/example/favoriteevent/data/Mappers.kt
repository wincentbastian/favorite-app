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

fun EventDetailDto.toUI(): EventDetailUI =
    EventDetailUI(
        id = id,
        name = name,
        mediaCover = mediaCover,
        category = category,
        cityName = cityName,
    )