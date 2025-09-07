package com.example.favoriteevent.data

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventUi(
    val id: Long,
    val title: String,
    val shortDesc: String,     // bisa dari summary atau description strip-HTML
    val htmlDesc: String,      // simpan HTML asli untuk halaman detail
    val imageThumb: String?,   // imageLogo
    val imageCover: String?,   // mediaCover
    val category: String,
    val owner: String,
    val city: String,
    val quota: Int,
    val registrants: Int,
    val beginTime: String,     // simpan apa adanya; format di UI
    val endTime: String,
    val link: String,
    val isFavorite: Boolean = false
) : Parcelable {
    // contoh field non-parcel (cache/temp) — tidak ikut dipass
    @IgnoredOnParcel
    var cachedPlainDesc: String? = null
}
