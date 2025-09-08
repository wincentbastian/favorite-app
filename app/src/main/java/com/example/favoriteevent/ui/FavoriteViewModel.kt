package com.example.favoriteevent.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.favoriteevent.data.EventUi
import com.example.favoriteevent.data.toEntity
import com.example.favoriteevent.data.db.FavoriteRepository
import kotlinx.coroutines.launch

class FavoriteViewModel(app: Application): AndroidViewModel(app) {

    val favorites = FavoriteRepository.getAll(app).asLiveData()

    fun toggleFavorite(item: EventUi) = viewModelScope.launch {
        val context = getApplication<Application>()
        val isFavorite = FavoriteRepository.isFavorite(context, item.id)
        if (isFavorite) FavoriteRepository.deleteById(context,item.id)
        else FavoriteRepository.insert(context, item.toEntity())
    }
}