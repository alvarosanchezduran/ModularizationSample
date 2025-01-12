package com.alvaro.samplemodularization.data.datasource.local.characters

import com.alvaro.samplemodularization.data.datasource.local.models.CharacterEntity

interface CharactersLocalDataSource {
    suspend fun getCharacters(): List<CharacterEntity>
    suspend fun insertCharacter(characterEntity: CharacterEntity)
}