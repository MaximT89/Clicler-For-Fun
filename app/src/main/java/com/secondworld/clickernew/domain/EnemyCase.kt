package com.secondworld.clickernew.domain

import javax.inject.Inject

class EnemyCase @Inject constructor() {

    fun createEnemyHp() = (2..10).random()

}