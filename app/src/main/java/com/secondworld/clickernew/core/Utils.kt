package com.secondworld.clickernew.core

import android.view.View
import android.widget.TextView
import com.secondworld.clickernew.data.repository.Repository

const val TAG = "TAG"

fun updateText(view: TextView, message: Any) {
    view.text = message.toString()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.enabled() {
    isEnabled = true
    isClickable = true
}

fun View.notEnabled() {
    isEnabled = false
    isClickable = false
}

