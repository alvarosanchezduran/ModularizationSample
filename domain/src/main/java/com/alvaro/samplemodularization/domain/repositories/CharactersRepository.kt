package com.alvaro.samplemodularization.domain.repositories

import com.alvaro.samplemodularization.domain.models.Character

interface CharactersRepository {
    suspend fun getCharacters(): List<Character>
}