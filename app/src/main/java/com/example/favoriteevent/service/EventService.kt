package com.example.favoriteevent.service

import com.example.favoriteevent.data.EventDetailResponse
import com.example.favoriteevent.data.EventResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EventService {
    @GET("events")
    suspend fun getEvents(@Query("active") active: Int): EventResponse

    @GET("events/{id}")
    suspend fun getEventDetailById(@Path("id") id: Long): EventDetailResponse
}