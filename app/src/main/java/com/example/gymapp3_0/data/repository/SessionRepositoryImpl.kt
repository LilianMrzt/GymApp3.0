package com.example.gymapp.data.repository

import com.example.gymapp.data.database.SessionDao
import com.example.gymapp.domain.models.SessionModel
import com.example.gymapp.domain.repository.SessionRepository

class BookRepositoryImpl(
    private val bookDao: SessionDao
) : SessionRepository {
    override fun getSessionsFromRoom() = bookDao.getBooks()

    override fun getSessionFromRoom(id: Int) = bookDao.getBook(id)

    override fun addSessionToRoom(book: SessionModel) = bookDao.addBook(book)

    override fun updateSessionInRoom(book: SessionModel) = bookDao.updateBook(book)

    override fun deleteSessionFromRoom(book: SessionModel) = bookDao.deleteBook(book)
}