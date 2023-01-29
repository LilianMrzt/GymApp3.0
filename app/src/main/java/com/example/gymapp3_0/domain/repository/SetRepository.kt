package com.example.gymapp3_0.domain.repository

import com.example.gymapp3_0.domain.models.SetModel
import kotlinx.coroutines.flow.Flow

typealias Sets = List<SetModel>

interface SetRepository {
    fun getSetsFromRoom(): Flow<Sets>

    fun getSetFromRoom(id: Int): SetModel

    fun addSetToRoom(set: SetModel)

    fun updateSetInRoom(set: SetModel)

    fun deleteSetFromRoom(set: SetModel)

}