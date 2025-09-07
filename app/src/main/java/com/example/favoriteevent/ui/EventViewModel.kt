package com.example.favoriteevent.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.favoriteevent.data.EventUi
import com.example.favoriteevent.service.EventRepositoryImpl
import kotlinx.coroutines.launch

class EventViewModel: ViewModel() {
    private val repo = EventRepositoryImpl

    private val _items = MutableLiveData<List<EventUi>>()
    val items = _items

    val loading = MutableLiveData(false)
    val error = MutableLiveData<String?>(null)

    fun loadUpcoming() = load { repo.fetchUpcomingEvent() }
    fun loadFinished() = load { repo.fetchFinished() }

    private fun load(block: suspend () -> List<EventUi>) = viewModelScope.launch {
        try {
            loading.value = true; error.value = null
            _items.value = block()
        } catch (t: Throwable) {
            println(t.message?: "Unknown error")
            error.value = t.message ?: "Unknown error"
        } finally {
            loading.value = false
        }
    }
}