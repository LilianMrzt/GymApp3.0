package com.example.gymapp3_0.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gymapp3_0.domain.models.ExerciseModel

@Database(entities = [ExerciseModel::class], version = 1, exportSchema = false)
abstract class ExerciseDb : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao
}