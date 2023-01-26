package com.example.gymapp3_0.data.repository

import com.example.gymapp3_0.data.database.ExerciseDao
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.domain.repository.ExerciseRepository

class ExerciseRepositoryImpl(
    private val exerciseDao: ExerciseDao
) : ExerciseRepository {
    override fun getExercisesFromRoom() = exerciseDao.getExercises()

    override fun getExerciseFromRoom(id: Int) = exerciseDao.getExercise(id)

    override fun addExerciseToRoom(exercise: ExerciseModel) = exerciseDao.addExercise(exercise)

    override fun updateExerciseInRoom(exercise: ExerciseModel) =
        exerciseDao.updateExercise(exercise)

    override fun deleteExerciseFromRoom(exercise: ExerciseModel) =
        exerciseDao.deleteExercise(exercise)
}