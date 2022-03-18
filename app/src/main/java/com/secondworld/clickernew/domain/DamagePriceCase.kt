package com.secondworld.clickernew.domain

import com.secondworld.clickernew.data.repository.Repository
import javax.inject.Inject

class DamagePriceCase @Inject constructor(private val repository: Repository) {

    fun getDamagePrice() = repository.getDamagePrice() + ratio()

    private fun ratio() = repository.getDamagePrice() / 100 * 20 + 1

}
