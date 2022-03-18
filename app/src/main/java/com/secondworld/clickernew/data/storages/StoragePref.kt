package com.secondworld.clickernew.data.storages

import android.content.SharedPreferences
import com.secondworld.clickernew.core.BaseSharedPreferences

object StoragePref : BaseSharedPreferences {

    private const val PROFILE_SCORE = "profile_score"
    private const val PROFILE_DAMAGE = "profile_damage"
    private const val PROFILE_DAMAGE_PRICE = "profile_damage_price"

    var SharedPreferences.score
        get() = getInt(PROFILE_SCORE, 0)
        set(value) = editMe { it.put(PROFILE_SCORE to value) }

    var SharedPreferences.damage
        get() = getInt(PROFILE_DAMAGE, 1)
        set(value) = editMe { it.put(PROFILE_DAMAGE to value) }

    var SharedPreferences.damagePrice
        get() = getInt(PROFILE_DAMAGE_PRICE, 1)
        set(value) = editMe { it.put(PROFILE_DAMAGE_PRICE to value) }
}