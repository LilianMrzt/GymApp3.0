package com.example.gymapp3_0.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gymapp3_0.core.Constants


@Entity(tableName = Constants.EXERCISE_TABLE)
data class ExerciseModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String = "",
    var muscle: String = "",

    @ColumnInfo(name = "isSelected")
    var isSelected: Boolean = false,
)

