package com.example.gymapp3_0.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.gymapp3_0.core.Constants
import com.google.gson.Gson


@Entity(tableName = Constants.EXERCISE_TABLE)
data class ExerciseModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String = "",
    var muscle: String = "",

    @ColumnInfo(name = "isSelected")
    var isSelected: Boolean = false,

    var setList: List<SetModel>,
)

class SetTypeConverter {
    @TypeConverter
    fun listToJson(value: List<SetModel>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) =
        Gson().fromJson(value, Array<SetModel>::class.java).toList()
}
