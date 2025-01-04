package com.alvaro.samplemodularization.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alvaro.samplemodularization.presentation.AppScreen

@Stable
@Composable
fun ModularizationAppNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            AppScreen()
        }
    }
}