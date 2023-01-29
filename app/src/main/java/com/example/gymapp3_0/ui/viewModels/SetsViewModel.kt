package com.example.gymapp3_0.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymapp3_0.domain.models.SetModel
import com.example.gymapp3_0.domain.repository.SetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SetsViewModel @Inject constructor(
    private val repo: SetRepository
) : ViewModel() {

    var set by mutableStateOf(SetModel(0, 0, 0, 0))
    var exercises = repo.getSetsFromRoom()
    
    fun getExercise(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        set = repo.getSetFromRoom(id)
    }

    fun addExercise(set: SetModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addSetToRoom(set)
        }
    }

    fun updateExercise(set: SetModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateSetInRoom(set)
        }
    }

    fun deleteExercise(set: SetModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteSetFromRoom(set)
        }
    }
}