package com.secondworld.clickernew.domain

import javax.inject.Inject

class ScoreCase @Inject constructor() {

    fun getScoreForTheEnemy() = (10..15).random()
}