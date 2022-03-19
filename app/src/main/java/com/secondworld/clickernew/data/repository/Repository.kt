package com.secondworld.clickernew.data.repository

import android.content.Context
import com.secondworld.clickernew.data.storages.StorageColors
import com.secondworld.clickernew.data.storages.StoragePref
import com.secondworld.clickernew.data.storages.StoragePref.critDamageChance
import com.secondworld.clickernew.data.storages.StoragePref.critDamageMultiply
import com.secondworld.clickernew.data.storages.StoragePref.damage
import com.secondworld.clickernew.data.storages.StoragePref.damagePrice
import com.secondworld.clickernew.data.storages.StoragePref.score
import javax.inject.Inject

class Repository @Inject constructor(context: Context) {

    private val prefs = StoragePref.defaultPref(context)

    fun setScore(value : Int) { prefs.score = value }
    fun updateScore(value : Int) { prefs.score += value }
    fun getScore() = prefs.score

    fun setDamage(value : Int) { prefs.damage = value }
    fun updateDamage(value : Int) { prefs.damage += value }
    fun getDamage() = prefs.damage

    fun setDamagePrice(value : Int) { prefs.damagePrice = value }
    fun updateDamagePrice(value : Int) { prefs.damagePrice += value }
    fun getDamagePrice() = prefs.damagePrice

    fun setCritDamageChance(value : Int) { prefs.critDamageChance = value }
    fun updateCritDamageChance(value : Int) { prefs.critDamageChance += value }
    fun getCritDamageChance() = prefs.critDamageChance

    fun setCritDamageMultiply(value : Int) { prefs.critDamageMultiply = value }
    fun updateCritDamageMultiply(value : Int) { prefs.critDamageMultiply += value }
    fun getCritDamageMultiply() = prefs.critDamageMultiply

    fun getRandomColor() = StorageColors.getRandomColor()



}
