package com.example.favoriteevent.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.text.HtmlCompat
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.favoriteevent.R
import com.example.favoriteevent.data.EventUi
import com.example.favoriteevent.databinding.FragmentDetailEventBinding

class DetailEvent : Fragment(R.layout.fragment_detail_event) {

    private var _binding: FragmentDetailEventBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailViewModel by viewModels()
    private val favoriteViewModel: FavoriteViewModel by viewModels()

    private val eventId: Long by lazy { requireArguments().getLong("eventId") }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentDetailEventBinding.bind(view)

        viewModel.loading.observe(viewLifecycleOwner) {
            binding.loadingDetailEvent.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewModel.data.observe(viewLifecycleOwner) { detail ->
            binding.eventTitle.text = detail!!.name
            Glide.with(binding.eventDetailImage).load(detail.mediaCover).into(binding.eventDetailImage)
            binding.eventDescription.text = detail.description
            binding.eventCategory.text = detail.category
            val spanned = HtmlCompat.fromHtml(detail.description.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)

            binding.eventDescription.text = spanned
            binding.eventDescription.movementMethod = LinkMovementMethod.getInstance()
            binding.eventQuota.text = "Quota: ${detail.quota}"


            favoriteViewModel.favorites.observe(viewLifecycleOwner) { list ->
                val isFav = list.any { it.id == eventId }
                binding.eventDetailFavorite.imageTintList =
                    androidx.appcompat.content.res.AppCompatResources.getColorStateList(
                        requireContext(),
                        if (isFav) R.color.red else R.color.white
                    )
            }

            binding.eventDetailFavorite.setOnClickListener {
                val eventUiFromDetail = EventUi(
                    id = detail.id,
                    title = detail.name,
                    shortDesc = detail.description!!,
                    image = detail.mediaCover,
                    quota = detail.quota,
                )
                favoriteViewModel.toggleFavorite(eventUiFromDetail)
            }
        }

        viewModel.load(eventId)
    }
}