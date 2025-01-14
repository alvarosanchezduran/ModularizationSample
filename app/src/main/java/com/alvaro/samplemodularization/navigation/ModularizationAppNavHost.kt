package com.alvaro.samplemodularization.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alvaro.samplemodularization.core.common.components.AndroidViewFragment
import com.alvaro.samplemodularization.feature.samplefragmentxml.R
import com.alvaro.samplemodularization.core.di.navigation.AppScreenRoute
import com.alvaro.samplemodularization.core.di.navigation.AuthScreenRoute
import com.alvaro.samplemodularization.core.di.navigation.Navigator
import com.alvaro.samplemodularization.core.di.navigation.PlayerScreenRoute
import com.alvaro.samplemodularization.core.di.navigation.SampleFragmentXmlScreenRoute
import com.alvaro.samplemodularization.core.di.navigation.StarWarsCharacterDetailScreenRoute
import com.alvaro.samplemodularization.core.di.navigation.StarWarsCharactersScreenRoute
import com.alvaro.samplemodularization.feature.authsupabase.AuthScreen
import com.alvaro.samplemodularization.feature.characterdetail.CharacterDetailScreen
import com.alvaro.samplemodularization.feature.player.PlayerScreen
import com.alvaro.samplemodularization.feature.samplefragmentxml.SampleFragment
import com.alvaro.samplemodularization.feature.starwarslist.CharacterListScreen
import com.alvaro.samplemodularization.presentation.AppScreen

@OptIn(ExperimentalMaterial3Api::class)
@Stable
@Composable
fun ModularizationAppNavHost(
    navController: NavHostController,
    navigator: Navigator,
    supportFragmentManager: FragmentManager?,
) {

    val isTopBarVisible = rememberSaveable { mutableStateOf(true) }

    Scaffold (topBar = {
        if(isTopBarVisible.value) {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Small Top App Bar")
                }
            )
        }
    }) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            NavHost(navController = navController, startDestination = AppScreenRoute.ROUTE) {
                composable(route = AppScreenRoute.ROUTE) {
                    AppScreen(
                        openCharactersListScreen = { navigator.navigate(StarWarsCharactersScreenRoute) },
                        openSampleXmlScreen = { param -> navigator.navigate(SampleFragmentXmlScreenRoute(param = param)) },
                        openAuthScreen = { navigator.navigate(AuthScreenRoute) },
                        openPlayerScreen = {
                            isTopBarVisible.value = false
                            navigator.navigate(PlayerScreenRoute)
                        }
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

                supportFragmentManager?.let { supportFragmentManager ->
                    composable(
                        route = SampleFragmentXmlScreenRoute.route
                    ) {
                        val data = it.arguments?.getString("input") ?: "Unknown"
                        AndroidViewFragment(
                            modifier = Modifier.fillMaxSize(),
                            fragmentId = R.id.fragment_sample_cl,
                            fragment = SampleFragment.newInstance(data),
                            fragmentManager = supportFragmentManager,
                            backPressHandler = {
                                navController.popBackStack()
                            }
                        )
                    }
                }

                composable(route = AuthScreenRoute.ROUTE) {
                    AuthScreen()
                }

                composable(route = PlayerScreenRoute.ROUTE) {
                    PlayerScreen()
                }
            }

        }
    }
}