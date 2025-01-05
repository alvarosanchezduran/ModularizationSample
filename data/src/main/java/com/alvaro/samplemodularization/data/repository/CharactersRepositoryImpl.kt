package com.alvaro.samplemodularization.data.repository

import com.alvaro.samplemodularization.data.datasource.remote.characters.CharactersRemoteDataSource
import com.alvaro.samplemodularization.domain.models.Character
import com.alvaro.samplemodularization.domain.repositories.CharactersRepository
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val remoteDataSource: CharactersRemoteDataSource
): CharactersRepository {

    override suspend fun getCharacters(): List<Character> {
        return remoteDataSource.getCharacters().toDomain()
    }

}