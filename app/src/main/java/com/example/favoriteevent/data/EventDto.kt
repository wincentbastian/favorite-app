package com.example.favoriteevent.data


data class EventDto(
    val id: Long,
    val name: String?,
    val summary: String?,
    val description: String?,
    val imageLogo: String?,
    val mediaCover: String?,
    val cityName: String?
)
