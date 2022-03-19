package com.secondworld.clickernew.domain

import com.secondworld.clickernew.data.repository.Repository
import javax.inject.Inject

class DamageCase @Inject constructor(private val repository: Repository) {

    fun getCurrentDamage() : Int {
        return repository.getDamage()
    }
}