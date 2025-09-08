package com.example.favoriteevent.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.favoriteevent.data.EventDetailUI
import com.example.favoriteevent.service.EventRepositoryImpl
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    val data = MutableLiveData<EventDetailUI?>()
    val loading = MutableLiveData(false)
    val error = MutableLiveData<String?>(null)

    fun load(id: Long) = viewModelScope.launch {
        try {
            loading.value = true
            error.value = null
            data.value = EventRepositoryImpl.fetchEventDetail(id)
        } catch (t: Throwable) {
            error.value = t.message ?: "Failed to load detail"
            data.value = null
        } finally {
            loading.value = false
        }
    }
}