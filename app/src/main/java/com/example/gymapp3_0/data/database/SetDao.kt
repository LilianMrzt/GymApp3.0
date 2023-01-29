package com.example.gymapp3_0.data.database

import androidx.room.*
import com.example.gymapp3_0.core.Constants
import com.example.gymapp3_0.domain.models.SetModel
import com.example.gymapp3_0.domain.repository.Sets
import kotlinx.coroutines.flow.Flow

@Dao
interface SetDao {
    @Query("SELECT * FROM ${Constants.SET_TABLE} ORDER BY id ASC")
    fun getSets(): Flow<Sets>

    @Query("SELECT * FROM ${Constants.SET_TABLE} WHERE id = :id")
    fun getSet(id: Int): SetModel

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addSet(set: SetModel)

    @Update
    fun updateSet(set: SetModel)

    @Delete
    fun deleteSet(set: SetModel)
}