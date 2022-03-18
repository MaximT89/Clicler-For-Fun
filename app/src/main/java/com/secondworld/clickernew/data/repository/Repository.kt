package com.secondworld.clickernew.data.repository

import android.content.Context
import com.secondworld.clickernew.data.prefs.StoragePref
import com.secondworld.clickernew.data.prefs.StoragePref.score
import javax.inject.Inject

class Repository @Inject constructor(context: Context) {

    private val prefs = StoragePref.defaultPref(context)

    fun setScore(value : Int) { prefs.score = value }
    fun updateScore(value : Int) { prefs.score += value }
    fun getScore() = prefs.score


}
