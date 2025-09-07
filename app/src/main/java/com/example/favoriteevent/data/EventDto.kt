package com.example.favoriteevent.data


data class EventDto(
    val id: Long,
    val name: String,
    val summary: String,
    val description: String,
    val imageLogo: String,
    val mediaCover: String,
    val category: String,
    val ownerName: String,
    val cityName: String,
    val quota: Int,
    val registrants: Int,
    val beginTime: String, // "yyyy-MM-dd HH:mm:ss"
    val endTime: String,
    val link: String
)
