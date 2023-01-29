package com.example.gymapp3_0.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gymapp3_0.domain.models.SetModel

@Database(entities = [SetModel::class], version = 1, exportSchema = false)
abstract class SetDb : RoomDatabase() {
    abstract fun setDao(): SetDao
}