package com.example.gymapp3_0.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.gymapp3_0.core.Constants.Companion.SESSION_TABLE
import com.google.gson.Gson

@Entity(tableName = SESSION_TABLE)
data class SessionModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String = "",
    var description: String = "",
    var exerciseList: List<ExerciseModel>
)

class ExerciseTypeConverter {
    @TypeConverter
    fun listToJson(value: List<ExerciseModel>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) =
        Gson().fromJson(value, Array<ExerciseModel>::class.java).toList()
}