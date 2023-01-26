package com.example.gymapp3_0.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gymapp3_0.domain.models.SessionModel

@Database(entities = [SessionModel::class], version = 1, exportSchema = false)
abstract class SessionDb : RoomDatabase() {
    abstract fun sessionDao(): SessionDao
}