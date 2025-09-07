package com.example.favoriteevent.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.favoriteevent.R
import com.example.favoriteevent.data.toUi
import com.example.favoriteevent.databinding.FragmentFavoriteEventBinding

class FavoriteEvent : Fragment(R.layout.fragment_favorite_event) {

    private var _binding: FragmentFavoriteEventBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FavoriteViewModel by viewModels()

    private val adapter = EventAdapter(
        onToggleFavorite = { viewModel.toggleFavorite(it) },
        onClick = { item, _ ->
            val args = Bundle().apply { putParcelable("event", item) }
        })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentFavoriteEventBinding.bind(view)

        binding.listFavorite.layoutManager = LinearLayoutManager(requireContext())
        binding.listFavorite.adapter = adapter

        viewModel.favorites.observe(viewLifecycleOwner) { favoriteList ->
            val favoriteItem = favoriteList.map { it.toUi() }
            adapter.submitList(favoriteItem)
            adapter.setFavoriteIds(favoriteItem.map { it.id }.toSet())
            binding.listFavorite.visibility = View.VISIBLE
            binding.errorTextView.visibility = View.GONE
        }
    }
}