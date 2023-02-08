package com.example.gymapp3_0.domain.models

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.gymapp3_0.core.Constants.Companion.SESSION_TABLE
import com.example.gymapp3_0.ui.theme.*
import com.google.gson.Gson


@Entity(tableName = SESSION_TABLE)
data class SessionModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String = "",
    var exerciseList: List<ExerciseModel>,
    val sessionColor: SessionColor
)

class ExerciseTypeConverter {
    @TypeConverter
    fun listToJson(value: List<ExerciseModel>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) =
        Gson().fromJson(value, Array<ExerciseModel>::class.java).toList()
}

enum class SessionColor {
    BLUE,
    RED,
    GREEN,
    YELLOW,
    ORANGE,
    PURPLE,
    BROWN,
    BLACK
}

fun SessionColor.toColor() = when (this) {
    SessionColor.BLUE -> ListBlue
    SessionColor.GREEN -> ListGreen
    SessionColor.YELLOW -> ListYellow
    SessionColor.RED -> ListRed
    SessionColor.ORANGE -> ListOrange
    SessionColor.PURPLE -> ListPurple
    SessionColor.BROWN -> ListBrown
    SessionColor.BLACK -> ListBlack
}

fun Color.toSessionColor() = when (this) {
    ListBlue -> SessionColor.BLUE
    ListGreen -> SessionColor.GREEN
    ListYellow -> SessionColor.YELLOW
    ListRed -> SessionColor.RED
    ListOrange -> SessionColor.ORANGE
    ListPurple -> SessionColor.PURPLE
    ListBrown -> SessionColor.BROWN
    ListBlack -> SessionColor.BLACK
    else -> SessionColor.BLUE
}