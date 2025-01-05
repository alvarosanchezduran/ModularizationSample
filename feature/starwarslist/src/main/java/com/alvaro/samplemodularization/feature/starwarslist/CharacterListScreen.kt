package com.alvaro.samplemodularization.feature.starwarslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alvaro.samplemodularization.core.common.components.BasicListItem
import androidx.hilt.navigation.compose.hiltViewModel


data class Person(
    val uid: String,
    val name: String
)

val exampleData = listOf(
    Person("1", "Luke Skywalker"),
    Person("2", "C-3PO"),
    Person("3", "R2-D2"),
    Person("4", "Darth Vader"),
    Person("5", "Leia Organa"),
    Person("6", "Owen Lars"),
    Person("7", "Beru Whitesun lars"),
    Person("8", "R5-D4"),
    Person("9", "Biggs Darklighter"),
    Person("10", "Obi-Wan Kenobi")
)

@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier,
    viewModel: CharacterListViewModel = hiltViewModel()
) {

    val characters by viewModel.characters.collectAsState()
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
            if(characters.isEmpty()) {
                Text("No hay elementos")
                return@Surface
            }
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(characters) {
                    BasicListItem(name = it.name)
                }
            }
        }
    }

}