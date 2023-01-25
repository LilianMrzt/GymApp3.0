package com.example.gymapp.data.database

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import com.example.gymapp.domain.models.SessionModel
import com.example.gymapp.domain.repository.Sessions
import com.example.gymapp3_0.core.Constants.Companion.SESSION_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface SessionDao {
    @Query("SELECT * FROM $SESSION_TABLE ORDER BY id ASC")
    fun getBooks(): Flow<Sessions>

    @Query("SELECT * FROM $SESSION_TABLE WHERE id = :id")
    fun getBook(id: Int): SessionModel

    @Insert(onConflict = IGNORE)
    fun addBook(book: SessionModel)

    @Update
    fun updateBook(book: SessionModel)

    @Delete
    fun deleteBook(book: SessionModel)
}