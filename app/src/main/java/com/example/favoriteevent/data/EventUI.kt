package com.example.favoriteevent.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventUi(
    val id: Long,
    val title: String,
    val shortDesc: String,
    val image: String?,
    val quota: String?
) : Parcelable
