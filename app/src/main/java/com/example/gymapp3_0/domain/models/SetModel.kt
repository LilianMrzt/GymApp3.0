package com.example.gymapp3_0.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gymapp3_0.core.Constants


@Entity(tableName = Constants.SET_TABLE)
data class SetModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var weight: String,
    var reps: String,
    var restTime: String,
    var exerciseId: Int,
)

