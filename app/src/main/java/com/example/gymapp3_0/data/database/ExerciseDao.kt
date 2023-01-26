package com.example.gymapp3_0.data.database

import androidx.room.*
import com.example.gymapp3_0.core.Constants
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.domain.repository.Exercises
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM ${Constants.EXERCISE_TABLE} ORDER BY id ASC")
    fun getExercises(): Flow<Exercises>

    @Query("SELECT * FROM ${Constants.EXERCISE_TABLE} WHERE id = :id")
    fun getExercise(id: Int): ExerciseModel

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addExercise(exercise: ExerciseModel)

    @Update
    fun updateExercise(exercise: ExerciseModel)

    @Delete
    fun deleteExercise(exercise: ExerciseModel)
}