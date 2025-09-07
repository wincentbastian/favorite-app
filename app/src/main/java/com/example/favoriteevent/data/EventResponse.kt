package com.example.favoriteevent.data

data class EventResponse(
    val error: Boolean,
    val message: String,
    val listEvents: List<EventDto>
)