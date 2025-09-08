package com.example.favoriteevent.data

data class EventDetailResponse(
    val error: Boolean,
    val message: String,
    val event: EventDetailDto
)
