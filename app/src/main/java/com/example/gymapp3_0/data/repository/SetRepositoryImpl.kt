package com.example.gymapp3_0.data.repository

import com.example.gymapp3_0.data.database.SetDao
import com.example.gymapp3_0.domain.models.SetModel
import com.example.gymapp3_0.domain.repository.SetRepository

class SetRepositoryImpl(
    private val setDao: SetDao
) : SetRepository {
    override fun getSetsFromRoom() = setDao.getSets()

    override fun getSetFromRoom(id: Int) = setDao.getSet(id)

    override fun addSetToRoom(set: SetModel) = setDao.addSet(set)

    override fun updateSetInRoom(set: SetModel) =
        setDao.updateSet(set)

    override fun deleteSetFromRoom(set: SetModel) =
        setDao.deleteSet(set)
}