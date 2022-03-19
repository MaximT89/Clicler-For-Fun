package com.secondworld.clickernew.data.storages

import android.content.SharedPreferences
import com.secondworld.clickernew.core.BaseSharedPreferences
import java.lang.reflect.Array.getDouble

object StoragePref : BaseSharedPreferences {

    private const val PROFILE_SCORE = "profile_score"
    private const val PROFILE_DAMAGE = "profile_damage"
    private const val PROFILE_DAMAGE_PRICE = "profile_damage_price"
    private const val PROFILE_CRIT_DAMAGE_CHANCE = "profile_crit_damage_chance"
    private const val PROFILE_CRIT_DAMAGE_MULTIPLY = "profile_crit_damage_multiply"

    var SharedPreferences.score
        get() = getInt(PROFILE_SCORE, 0)
        set(value) = editMe { it.put(PROFILE_SCORE to value) }

    var SharedPreferences.damage
        get() = getInt(PROFILE_DAMAGE, 1)
        set(value) = editMe { it.put(PROFILE_DAMAGE to value) }

    var SharedPreferences.damagePrice
        get() = getInt(PROFILE_DAMAGE_PRICE, 1)
        set(value) = editMe { it.put(PROFILE_DAMAGE_PRICE to value) }

    var SharedPreferences.critDamageChance
        get() = getInt(PROFILE_CRIT_DAMAGE_CHANCE, 10)
        set(value) = editMe { it.put(PROFILE_CRIT_DAMAGE_CHANCE to value) }

    var SharedPreferences.critDamageMultiply
        get() = getInt(PROFILE_CRIT_DAMAGE_MULTIPLY, 150)
        set(value) = editMe { it.put(PROFILE_CRIT_DAMAGE_MULTIPLY to value) }
}