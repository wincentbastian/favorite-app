package com.example.favoriteevent.service

import com.example.favoriteevent.data.EventDetailUI
import com.example.favoriteevent.data.EventUi
import com.example.favoriteevent.data.toUI
import com.example.favoriteevent.data.toUi

object EventRepositoryImpl: EventRepository {
    override suspend fun fetchUpcomingEvent(): List<EventUi> =
        Api.provideService().getEvents(active = 1).listEvents.map { it.toUi()}


    override suspend fun fetchFinished(): List<EventUi> =
        Api.provideService().getEvents(active = 0).listEvents.map { it.toUi() }

    override suspend fun fetchEventDetail(id: Long): EventDetailUI {
        val res = Api.provideService().getEventDetailById(id)
        if (res.error) error(res.message)
        return res.event.toUI()
    }
}