package com.example.favoriteevent.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.favoriteevent.R
import com.example.favoriteevent.data.EventUi
import com.example.favoriteevent.databinding.FragmentDetailEventBinding

class DetailEvent : Fragment(R.layout.fragment_detail_event) {

    private var _binding: FragmentDetailEventBinding? = null
    private val binding get() = _binding

    private val viewModel: FavoriteViewModel by viewModels()

    private val eventId: Long by lazy { requireArguments().getLong("eventId") }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentDetailEventBinding.bind(view)

        viewModel.favorites
    }
}