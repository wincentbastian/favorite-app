package com.example.favoriteevent.data.models

data class EventResponse(
    val error: Boolean,
    val message: String,
    val listEvents: List<EventDto>
)