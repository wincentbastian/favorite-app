package com.example.favoriteevent.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.favoriteevent.R
import com.example.favoriteevent.databinding.FragmentFinishedEventBinding
import kotlin.getValue

class FinishedEvent : Fragment(R.layout.fragment_finished_event) {

    private var _binding: FragmentFinishedEventBinding? = null

    private val binding get() = _binding!!

    private val viewModel: EventViewModel by viewModels()

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    private val adapter = EventAdapter(
        onToggleFavorite = { favoriteViewModel.toggleFavorite(it) },
        onClick = { item, _ ->
            val args = Bundle().apply { putParcelable("event", item) }
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentFinishedEventBinding.bind(view)

        binding.finishListEvent.layoutManager = LinearLayoutManager(requireContext())
        binding.finishListEvent.adapter = adapter

        viewModel.items.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.finishListEvent.visibility = View.VISIBLE
            binding.errorTextView.visibility = View.GONE

        }

        viewModel.error.observe(viewLifecycleOwner) {
            binding.errorTextView.text = it
            binding.errorTextView.visibility = View.VISIBLE
        }

        viewModel.loadFinished()
    }
}