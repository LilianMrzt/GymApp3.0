package com.example.gymapp3_0.ui.navigation

import androidx.annotation.StringRes
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.gymapp3_0.R
import com.example.gymapp3_0.ui.screens.Screen
import com.example.gymapp3_0.ui.screens.session_screens.SessionsMainBody

enum class AddSessionRoutes(@StringRes val title: Int) {
    Start(R.string.main_session_screen),
    CreateSession(R.string.create_session),
    SeeSession(R.string.see_session),
}

fun NavGraphBuilder.sessionListNavigation(
    navController: NavHostController
) {
    navigation(
        startDestination = AddSessionRoutes.Start.name,
        route = Screen.Sessions.route
    ) {

        //MainSessionBody
        composable(
            route = AddSessionRoutes.Start.name
        ) {
            SessionsMainBody(
                /*
                navigateToCreateSession = {
                    navController.navigate(AddSessionRoutes.CreateSession.name)
                },


                navigateToViewSession = { sessionId ->
                    navController.navigate("${AddSessionRoutes.SeeSession.name}/${sessionId}")
                } */
            )
        }
/*
        //SeeSession
        composable(
            route = "${AddSessionRoutes.SeeSession.name}/{$SESSION_ID}",
            arguments = listOf(
                navArgument(SESSION_ID) {
                    type = IntType
                }
            )
        ) { backStackEntry ->
            val sessionId = backStackEntry.arguments?.getInt(SESSION_ID) ?: 0
            ViewSessionBody(
                sessionId = sessionId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

 */

        /*
        composable(route = AddSessionRoutes.CreateSession.name) {
            CreateSessionBody(
                modifier = Modifier
            )
        }

         */

    }
}