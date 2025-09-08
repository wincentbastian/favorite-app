package com.example.favoriteevent.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventDetailUI(
    val id: Long,
    val name: String,
    val mediaCover: String,
    val category: String,
    val cityName: String,
): Parcelable
