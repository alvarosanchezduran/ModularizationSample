package com.alvaro.samplemodularization.data.datasource.remote.characters

import com.alvaro.samplemodularization.data.datasource.remote.models.CharactersResponse

interface CharactersRemoteDataSource {
    suspend fun getCharacters(): CharactersResponse
}