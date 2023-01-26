package com.example.gymapp3_0.domain.repository

import com.example.gymapp3_0.domain.models.SessionModel
import kotlinx.coroutines.flow.Flow

typealias Sessions = List<SessionModel>

interface SessionRepository {
    fun getSessionsFromRoom(): Flow<Sessions>

    fun getSessionFromRoom(id: Int): SessionModel

    fun addSessionToRoom(session: SessionModel)

    fun updateSessionInRoom(session: SessionModel)

    fun deleteSessionFromRoom(session: SessionModel)
}