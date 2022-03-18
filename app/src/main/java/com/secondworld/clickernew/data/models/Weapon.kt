package com.secondworld.clickernew.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Weapon(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val price: Int,
    val damage: Int
)
