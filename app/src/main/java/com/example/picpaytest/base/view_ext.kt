package com.example.picpaytest.base

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(imageUrl: String, circle: Boolean = false, errorPlaceholder: Int? = null) {

    val requestOptions = RequestOptions().apply {
        if (circle) circleCrop()
        if (errorPlaceholder != null) placeholder(errorPlaceholder)
    }

    Glide.with(context)
        .applyDefaultRequestOptions(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA))
        .load(imageUrl)
        .apply(requestOptions)
        .into(this)
}
