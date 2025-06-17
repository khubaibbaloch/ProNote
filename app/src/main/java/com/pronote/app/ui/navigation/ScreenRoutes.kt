package com.pronote.app.ui.navigation

sealed class ScreenRoutes(val route: String) {
    data object HomeScreen : ScreenRoutes(route = "HomeScreen")
    data object AddNoteScreen : ScreenRoutes(route = "AddNoteScreen")
}