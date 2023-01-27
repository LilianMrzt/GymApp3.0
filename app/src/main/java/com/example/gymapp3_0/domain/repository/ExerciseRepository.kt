package com.example.gymapp3_0.domain.repository

import com.example.gymapp3_0.domain.models.ExerciseModel
import kotlinx.coroutines.flow.Flow

typealias Exercises = List<ExerciseModel>

interface ExerciseRepository {
    fun getExercisesFromRoom(): Flow<Exercises>

    fun getExerciseFromRoom(id: Int): ExerciseModel

    fun addExerciseToRoom(exercise: ExerciseModel)

    fun updateExerciseInRoom(exercise: ExerciseModel)

    fun deleteExerciseFromRoom(exercise: ExerciseModel)
    
}