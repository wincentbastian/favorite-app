package com.example.favoriteevent.service

import com.example.favoriteevent.data.EventResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EventService {
    @GET("events")
    suspend fun getEvents(@Query("active") active: Int): EventResponse
}