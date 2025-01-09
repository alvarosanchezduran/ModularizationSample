package com.alvaro.samplemodularization.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.fragment.app.FragmentManager
import androidx.navigation.compose.rememberNavController
import com.alvaro.samplemodularization.core.di.navigation.Navigator
import com.alvaro.samplemodularization.navigation.ModularizationAppNavHost

@Stable
@Composable
fun ModularizationApp(navigator: Navigator, supportFragmentManager: FragmentManager? = null) {
    val navController = rememberNavController()

    DisposableEffect(key1 = navController) {
        navigator.setController(navController)
        onDispose {
            navigator.clear()
        }
    }

    ModularizationAppNavHost(navController, navigator, supportFragmentManager)
}