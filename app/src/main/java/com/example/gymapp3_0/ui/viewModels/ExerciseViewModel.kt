package com.example.gymapp3_0.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.domain.models.SetModel
import com.example.gymapp3_0.domain.repository.ExerciseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val repo: ExerciseRepository
) : ViewModel() {

    private val modelList = MutableList<SetModel>(4) {
        SetModel(
            id = it,
            reps = "8",
            weight = "0",
            restTime = "1"
        )
    }

    var exercise: ExerciseModel by mutableStateOf(
        ExerciseModel(0, "", "", false, modelList)
    )
    
    var exercises = repo.getExercisesFromRoom()

    fun getExercise(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        exercise = repo.getExerciseFromRoom(id)
    }

    fun addExercise(exercise: ExerciseModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addExerciseToRoom(exercise)
        }
    }

    fun updateExercise(exercise: ExerciseModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateExerciseInRoom(exercise)
        }
    }

    fun deleteExercise(exercise: ExerciseModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteExerciseFromRoom(exercise)
        }
    }
}