package com.secondworld.clickernew.data.storages

import com.secondworld.clickernew.R

object StorageColors {

    fun getRandomColor() = listColor[(listColor.indices).random()]

    private val listColor = arrayOf(
        R.color.white,
        R.color.teal_700,
        R.color.purple_700,
        R.color.yellow,
        R.color.red
    )
}