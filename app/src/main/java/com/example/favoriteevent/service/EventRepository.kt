package com.example.favoriteevent.service

import com.example.favoriteevent.data.EventUi

interface EventRepository {
    suspend fun fetchUpcomingEvent(): List<EventUi>
    suspend fun fetchFinished(): List<EventUi>
}