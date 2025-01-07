package com.alvaro.samplemodularization.domain.repositories

import com.alvaro.samplemodularization.domain.models.Character
import com.alvaro.samplemodularization.domain.models.CharacterDetail

interface CharactersRepository {
    suspend fun getCharacters(): List<Character>
    suspend fun getCharacterDetail(id: String): CharacterDetail
}