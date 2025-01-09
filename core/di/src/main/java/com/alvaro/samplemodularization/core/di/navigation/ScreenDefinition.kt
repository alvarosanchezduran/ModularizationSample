package com.alvaro.samplemodularization.core.di.navigation

import androidx.lifecycle.SavedStateHandle

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

data class SampleFragmentXmlScreenRoute(val param: String) : NavigationRoute {
    constructor(savedStateHandle: SavedStateHandle) : this(
        param = requireNotNull(savedStateHandle.get<String>(inputArg))
    )

    override fun buildRoute(): String = "$root/$param"

    companion object {
        private const val root = "sample_fragment_screen"
        private const val inputArg = "input"

        const val route = "$root/{$inputArg}"
    }
}

data class StarWarsCharacterDetailScreenRoute(val id: String) : NavigationRoute {
    constructor(savedStateHandle: SavedStateHandle) : this(
        id = requireNotNull(savedStateHandle.get<String>(inputArg))
    )

    override fun buildRoute(): String = "$root/$id"

    companion object {
        private const val root = "characters_detail_screen"
        private const val inputArg = "input"

        const val route = "$root/{$inputArg}"
    }
}