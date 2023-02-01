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

    var set by mutableStateOf(SetModel(0, "0", "0", "0", 0))
    var exercises = repo.getSetsFromRoom()
    var openDialog by mutableStateOf(false)
    var openDialogForModification by mutableStateOf(false)
    val sets = repo.getSetsFromRoom()

    fun getSet(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        set = repo.getSetFromRoom(id)
    }

    fun addSet(set: SetModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addSetToRoom(set)
        }
    }

    fun updateSet(set: SetModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateSetInRoom(set)
        }
    }

    fun deleteSet(set: SetModel) = viewModelScope.launch(Dispatchers.IO) {
        repo.deleteSetFromRoom(set)
    }

    fun updateWeight(weight: String) {
        set = set.copy(
            weight = weight
        )
    }

    fun updateReps(reps: String) {
        set = set.copy(
            reps = reps
        )
    }

    fun updateRest(rest: String) {
        set = set.copy(
            restTime = rest
        )
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

    fun openDialogForModification() {
        openDialogForModification = true
    }

    fun closeDialogForModification() {
        openDialogForModification = false
    }

}