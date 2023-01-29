package com.example.gymapp3_0.data.states

import com.example.gymapp3_0.domain.models.ExerciseModel

data class SessionUiState(
    val temporaryList: List<ExerciseModel> = mutableListOf()
)