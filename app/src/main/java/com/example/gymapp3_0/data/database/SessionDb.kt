package com.example.gymapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gymapp.domain.models.SessionModel

@Database(entities = [SessionModel::class], version = 1, exportSchema = false)
abstract class SessionDb : RoomDatabase() {
    abstract fun sessionDao(): SessionDao
}