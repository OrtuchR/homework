package com.gmail.ortuchr.homework.presentation.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("imageURL")
fun setImageURL(image: ImageView, imageURL: String) {
    Glide.with(image.context)
            .load(imageURL)
            .into(image)
}