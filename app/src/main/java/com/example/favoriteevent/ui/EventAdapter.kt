package com.example.favoriteevent.ui

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.favoriteevent.R
import com.example.favoriteevent.data.EventUi

class EventAdapter(
    private val onClick: (EventUi, View) -> Unit,
    private val onToggleFavorite: (EventUi) -> Unit
) : ListAdapter<EventUi, EventAdapter.VH>(diff) {

    private var favoriteIds: Set<Long> = emptySet()
    fun setFavoriteIds(ids: Set<Long>) {
        favoriteIds = ids
        notifyDataSetChanged()
    }

    companion object {
        val diff = object : DiffUtil.ItemCallback<EventUi>() {
            override fun areItemsTheSame(a: EventUi, b: EventUi) = a.id == b.id
            override fun areContentsTheSame(a: EventUi, b: EventUi) = a == b
        }
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        private val img = view.findViewById<ImageView>(R.id.event_image)
        private val tvTitle = view.findViewById<TextView>(R.id.event_title)
        private val tvDesc  = view.findViewById<TextView>(R.id.event_desc)
        private val ibFav = view.findViewById<ImageButton>(R.id.favorite_button)

        fun bind(item: EventUi) {
            tvTitle.text = item.title
            tvDesc.text  = item.shortDesc

            if (!item.image .isNullOrBlank())
                Glide.with(img).load(item.image).into(img)
            else
                img.setImageResource(R.drawable.ic_launcher_foreground)

            itemView.setOnClickListener { onClick(item, itemView) }
            ibFav.setOnClickListener { onToggleFavorite(item) }

            val isFav = favoriteIds.contains(item.id)
            ibFav.imageTintList = ColorStateList.valueOf(
                ContextCompat.getColor(itemView.context, if (isFav) R.color.red else R.color.black)
            )


        }
    }

    override fun onCreateViewHolder(p: ViewGroup, vt: Int) =
        VH(LayoutInflater.from(p.context).inflate(R.layout.layout_event, p, false))

    override fun onBindViewHolder(h: VH, pos: Int) = h.bind(getItem(pos))
}