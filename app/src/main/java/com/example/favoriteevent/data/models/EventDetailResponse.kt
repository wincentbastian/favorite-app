package com.example.favoriteevent.data.models

data class EventDetailResponse(
    val error: Boolean,
    val message: String,
    val event: EventDetailDto
)