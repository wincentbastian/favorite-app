package com.example.favoriteevent.data

data class EventDetailDto(
    val id: Long,
    val name: String,
    val summary: String?,
    val description: String?,
    val mediaCover: String,
    val category: String,
    val cityName: String,
)
