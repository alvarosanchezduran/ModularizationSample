package com.alvaro.samplemodularization.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alvaro.samplemodularization.core.di.navigation.AppScreenRoute
import com.alvaro.samplemodularization.core.di.navigation.Navigator
import com.alvaro.samplemodularization.core.di.navigation.StarWarsCharacterDetailScreenRoute
import com.alvaro.samplemodularization.core.di.navigation.StarWarsCharactersScreenRoute
import com.alvaro.samplemodularization.feature.characterdetail.CharacterDetailScreen
import com.alvaro.samplemodularization.feature.starwarslist.CharacterListScreen
import com.alvaro.samplemodularization.presentation.AppScreen

@Stable
@Composable
fun ModularizationAppNavHost(
    navController: NavHostController,
    navigator: Navigator,
) {
    NavHost(navController = navController, startDestination = AppScreenRoute.ROUTE) {
        composable(route = AppScreenRoute.ROUTE) {
            AppScreen(
                openCharactersListScreen = { navigator.navigate(StarWarsCharactersScreenRoute) }
            )
        }

        composable(route = StarWarsCharactersScreenRoute.ROUTE) {
            CharacterListScreen(
                openCharacterDetailScreen = { id -> navigator.navigate(StarWarsCharacterDetailScreenRoute(id = id)) }
            )
        }

        composable(route = StarWarsCharacterDetailScreenRoute.route) {
            CharacterDetailScreen()
        }
    }
}