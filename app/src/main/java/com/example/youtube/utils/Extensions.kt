package com.example.youtube.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String, placeholder: Int = 0){
    Glide.with(this.context)
        .load(url)
        .placeholder(placeholder)
        .into(this)
}
fun Context.showToastShort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
