package com.example.gymapp3_0.data.repository

import com.example.gymapp3_0.data.database.SessionDao
import com.example.gymapp3_0.domain.models.SessionModel
import com.example.gymapp3_0.domain.repository.SessionRepository

class SessionRepositoryImpl(
    private val sessionDao: SessionDao
) : SessionRepository {
    override fun getSessionsFromRoom() = sessionDao.getSessions()

    override fun getSessionFromRoom(id: Int) = sessionDao.getSession(id)

    override fun addSessionToRoom(session: SessionModel) = sessionDao.addSession(session)

    override fun updateSessionInRoom(session: SessionModel) = sessionDao.updateSession(session)

    override fun deleteSessionFromRoom(session: SessionModel) = sessionDao.deleteSession(session)
}