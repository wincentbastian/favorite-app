package com.example.favoriteevent.data

fun EventDto.toUi(isFavorite: Boolean = false): EventUi =
    EventUi(
        id = id,
        title = name,
        shortDesc = if (summary.isNotBlank()) summary else description,
        htmlDesc = description,
        imageThumb = imageLogo.ifBlank { mediaCover },
        imageCover = mediaCover,
        category = category,
        owner = ownerName,
        city = cityName,
        quota = quota,
        registrants = registrants,
        beginTime = beginTime,
        endTime = endTime,
        link = link,
        isFavorite = isFavorite
    )