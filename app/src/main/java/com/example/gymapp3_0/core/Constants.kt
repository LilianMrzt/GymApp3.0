package com.example.gymapp3_0.core

import androidx.compose.ui.unit.dp

class Constants {
    companion object {
        //Room
        const val SESSION_TABLE = "session_table"
        const val EXERCISE_TABLE = "exercise_table"
        const val SET_TABLE = "set_table"

        //Arguments
        const val SESSION_ID = "sessionId"
        const val EXERCISE_ID = "exerciseId"
        const val SET_ID = "setId"

        //Actions
        const val ADD_SESSION = "Add a session."
        const val DELETE_SESSION = "Delete a session."

        const val NO_VALUE = ""

        //CONSTANTS
        val ROUNDED_CORNER = 10.dp
    }
}