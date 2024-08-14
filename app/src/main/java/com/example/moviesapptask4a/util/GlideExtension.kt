package com.example.moviesapptask4a.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.moviesapptask4a.R

fun ImageView.loadCircleImage(path: String) {
    val requestOptions = RequestOptions()
        .transform(RoundedCorners(30))
        .error(R.drawable.error)
        .centerCrop()
    Glide.with(this.context)
        .load(Constans.BASE_IMAGE_URL+path)
        .apply(requestOptions)
        .into(this)
}
fun ImageView.loadImage(path: String) {
    val requestOptions = RequestOptions()
        .error(R.drawable.error)
    Glide.with(this.context)
        .load(Constans.BASE_IMAGE_URL+path)
        .apply(requestOptions)
        .into(this)
}