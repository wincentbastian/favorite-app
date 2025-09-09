package com.example.favoriteevent.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventDetailUI(
    val id: Long,
    val name: String,
    val summary: String?,
    val description: String?,
    val mediaCover: String,
    val category: String,
    val cityName: String,
    val quota: String,
    val registrants: String
): Parcelable
