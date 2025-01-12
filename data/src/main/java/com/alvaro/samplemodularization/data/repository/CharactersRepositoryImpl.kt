package com.alvaro.samplemodularization.data.repository

import com.alvaro.samplemodularization.data.datasource.local.characters.CharactersLocalDataSource
import com.alvaro.samplemodularization.data.datasource.remote.characters.CharactersRemoteDataSource
import com.alvaro.samplemodularization.domain.models.Character
import com.alvaro.samplemodularization.domain.models.CharacterDetail
import com.alvaro.samplemodularization.domain.repositories.CharactersRepository
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val remoteDataSource: CharactersRemoteDataSource,
    private val localDataSource: CharactersLocalDataSource
): CharactersRepository {

    override suspend fun getCharacters(): List<Character> {
        val localCharacters = localDataSource.getCharacters()
        return if(localCharacters.isNotEmpty()) {
            localCharacters.map { it.toDomain() }
        } else {
            val remoteCharacters = remoteDataSource.getCharacters()
            remoteCharacters.toEntity().forEach {
                localDataSource.insertCharacter(it)
            }
            return remoteCharacters.toDomain()
        }
    }

    override suspend fun getCharacterDetail(id: String): CharacterDetail {
        return remoteDataSource.getCharacterDetail(id).toDomain()
    }

}