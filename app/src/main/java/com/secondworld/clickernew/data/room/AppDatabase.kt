package com.secondworld.clickernew.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.secondworld.clickernew.data.models.Weapon

@Database(entities = [Weapon::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weaponDao() : WeaponDao
}