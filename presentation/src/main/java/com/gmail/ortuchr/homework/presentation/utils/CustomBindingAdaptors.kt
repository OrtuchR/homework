package com.gmail.ortuchr.homework.presentation.utils

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("imageURL")
fun setImageURL(image: ImageView, imageURL: String) {
    Glide.with(image.context)
            .load(imageURL)
            .into(image)
}

@BindingAdapter("visibility")
fun View.visibility(visibility: Boolean) {
    this.visibility = if(visibility) View.VISIBLE else View.GONE
}
