package com.alvaro.samplemodularization.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppScreen(
    modifier: Modifier = Modifier,
    openCharactersListScreen: () -> Unit,
    openSampleXmlScreen: (String) -> Unit
) {
    Scaffold(modifier = modifier) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            AppContent(
                openCharactersListScreen,
                openSampleXmlScreen
            )
        }
    }
}

@Composable
fun AppContent(
    openCharactersListScreen: () -> Unit,
    openSampleXmlScreen: (String) -> Unit
) {
    Column {
        Button(onClick = {
            openCharactersListScreen()
        }) {
            Text(text = "Character list")
        }
        Button(onClick = {
            openSampleXmlScreen("Sample Fragment with PARAM")
        }) {
            Text(text = "Sample XML")
        }
    }


}