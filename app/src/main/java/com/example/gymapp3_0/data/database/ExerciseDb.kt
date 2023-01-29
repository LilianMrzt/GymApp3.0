package com.example.gymapp3_0.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.domain.models.SetTypeConverter

@Database(entities = [ExerciseModel::class], version = 1, exportSchema = false)
@TypeConverters(SetTypeConverter::class)
abstract class ExerciseDb : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao
}