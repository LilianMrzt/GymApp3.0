package com.example.gymapp3_0.data.database

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import com.example.gymapp3_0.core.Constants.Companion.SESSION_TABLE
import com.example.gymapp3_0.domain.models.SessionModel
import com.example.gymapp3_0.domain.repository.Sessions
import kotlinx.coroutines.flow.Flow

@Dao
interface SessionDao {
    @Query("SELECT * FROM $SESSION_TABLE ORDER BY id ASC")
    fun getSessions(): Flow<Sessions>

    @Query("SELECT * FROM $SESSION_TABLE WHERE id = :id")
    fun getSession(id: Int): SessionModel

    @Insert(onConflict = IGNORE)
    fun addSession(book: SessionModel)

    @Update
    fun updateSession(book: SessionModel)

    @Delete
    fun deleteSession(book: SessionModel)
}