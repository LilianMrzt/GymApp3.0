package com.example.gymapp.domain.repository

import com.example.gymapp.domain.models.SessionModel
import kotlinx.coroutines.flow.Flow

typealias Sessions = List<SessionModel>

interface SessionRepository {
    fun getSessionsFromRoom(): Flow<Sessions>

    fun getSessionFromRoom(id: Int): SessionModel

    fun addSessionToRoom(book: SessionModel)

    fun updateSessionInRoom(book: SessionModel)

    fun deleteSessionFromRoom(book: SessionModel)
}