package com.alvaro.samplemodularization.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.navigation.compose.rememberNavController
import com.alvaro.samplemodularization.navigation.ModularizationAppNavHost

@Stable
@Composable
fun ModularizationApp() {
    val navController = rememberNavController()

    DisposableEffect(key1 = navController) {
        onDispose {
        }
    }

    ModularizationAppNavHost(navController)
}