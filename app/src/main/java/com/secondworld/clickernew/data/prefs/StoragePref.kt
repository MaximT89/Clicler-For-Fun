package com.secondworld.clickernew.data.prefs

import android.content.SharedPreferences
import com.secondworld.clickernew.core.BaseSharedPreferences

object StoragePref : BaseSharedPreferences {

    private const val PROFILE_SCORE = "profile_score"

    var SharedPreferences.score
        get() = getInt(PROFILE_SCORE, 0)
        set(value) = editMe {
            it.put(PROFILE_SCORE to value)
        }
}