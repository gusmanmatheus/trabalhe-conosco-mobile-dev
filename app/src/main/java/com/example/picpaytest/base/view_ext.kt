package com.example.picpaytest.base

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(imageUrl: String, circle: Boolean = true, errorPlaceholder: Int? = null) {

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

fun EditText.changeText(change:()->Unit){
    this.addTextChangedListener(
        object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                change()
            }
        } )
}
