package com.example.gymapp3_0.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymapp3_0.domain.models.SessionModel
import com.example.gymapp3_0.domain.repository.SessionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(
    private val repo: SessionRepository
) : ViewModel() {

    var session by mutableStateOf(SessionModel(0, "", ""))
    var openDialog by mutableStateOf(false)
    var sessions = repo.getSessionsFromRoom()


    fun getSession(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        session = repo.getSessionFromRoom(id)
    }

    fun updateName(name: String) {
        session = session.copy(name = name)
    }

    fun updateDescription(description: String) {
        session = session.copy(description = description)
    }


    fun addSession(session: SessionModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addSessionToRoom(session)
        }
    }

    fun updateSession(session: SessionModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateSessionInRoom(session)
        }
    }

    fun deleteSession(session: SessionModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteSessionFromRoom(session)
        }
    }
}