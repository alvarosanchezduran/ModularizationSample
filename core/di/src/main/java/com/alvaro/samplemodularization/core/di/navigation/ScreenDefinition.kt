package com.alvaro.samplemodularization.core.di.navigation

object AppScreenRoute: NavigationRoute {
    override fun buildRoute(): String = ROUTE
    private const val ROOT = "app_screen"
    const val ROUTE = ROOT
}

object StarWarsCharactersScreenRoute : NavigationRoute {
    override fun buildRoute(): String = ROUTE
    private const val ROOT = "characters_screen"
    const val ROUTE = ROOT
}