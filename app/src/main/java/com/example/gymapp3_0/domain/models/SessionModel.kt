package com.example.gymapp3_0.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gymapp3_0.core.Constants.Companion.SESSION_TABLE

@Entity(tableName = SESSION_TABLE)
data class SessionModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String = "",
    var description: String = "",
)

