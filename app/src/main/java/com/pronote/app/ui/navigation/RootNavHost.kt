package com.pronote.app.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pronote.app.ui.screens.AddNoteScreen
import com.pronote.app.ui.screens.HomeScreen
import com.pronote.app.viewmodel.MainViewmodel

@Composable
fun RootNavHost(navHostController: NavHostController, mainViewmodel: MainViewmodel) {
    NavHost(navController = navHostController, startDestination = ScreenRoutes.HomeScreen.route,enterTransition = {
        scaleIn(
            initialScale = 0.95f,
            animationSpec = tween(160)
        ) + fadeIn(animationSpec = tween(100))
    },
        exitTransition = {
            scaleOut(
                targetScale = .95f,
                animationSpec = tween(160)
            ) + fadeOut(animationSpec = tween(150))
        },
        popEnterTransition = {
            scaleIn(initialScale = .95f, animationSpec = tween(160)) + fadeIn(
                animationSpec = tween(
                    100
                )
            )
        },
        popExitTransition = {
            scaleOut(
                targetScale = .95f,
                animationSpec = tween(160)
            ) + fadeOut(animationSpec = tween(150))
        }
    )  {
        composable(route = ScreenRoutes.HomeScreen.route) {
            HomeScreen(mainViewmodel = mainViewmodel, navController = navHostController)
        }
        composable(route = ScreenRoutes.AddNoteScreen.route) {
            AddNoteScreen(navController = navHostController, mainViewmodel = mainViewmodel)
        }
    }
}