package com.alvaro.samplemodularization.feature.characterdetail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CharacterDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: CharacterDetailViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.fetchCharacterDetail()
    }

    val character by viewModel.character.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()

    Scaffold(modifier = modifier) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            if (loading) {
                Text("Cargando...")
                return@Surface
            }
            if (error != null) {
                Text("Error: ${error}")
            }
            if(character == null) {
                Text("No hay elementos")
                return@Surface
            }
            Text("${character?.name}")
        }
    }

}