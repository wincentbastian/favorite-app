package com.example.favoriteevent.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.favoriteevent.R
import com.example.favoriteevent.databinding.FragmentUpcomingEventBinding

class UpcomingEvent : Fragment() {
    private var _binding: FragmentUpcomingEventBinding? = null
    private val binding get() = _binding!!

    private val viewModel: EventViewModel by viewModels()

    private val adapter = EventAdapter { item, _ ->
        val args = Bundle().apply { putParcelable("event", item) }
//        findNavController().navigate(R.id.dest_event_detail, args)
    }

    private val filter: String by lazy {
        requireArguments().getString("filter") ?: "UPCOMING"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentUpcomingEventBinding.bind(view)

        binding.listEvent.layoutManager = LinearLayoutManager(requireContext())
        binding.listEvent.adapter = adapter

        viewModel.items.observe(viewLifecycleOwner) { adapter.submitList(it) }
//        viewModel.loading.observe(viewLifecycleOwner) { binding.progress.isVisible = it }
//        viewModel.error.observe(viewLifecycleOwner) {
//            binding.tvError.text = it
//            binding.tvError.isVisible = it != null
//        }

        if (filter == "FINISHED") viewModel.loadFinished() else viewModel.loadUpcoming()
    }
}