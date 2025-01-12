package com.alvaro.samplemodularization.data.datasource.local.characters

import com.alvaro.samplemodularization.data.datasource.local.daos.CharacterDao
import com.alvaro.samplemodularization.data.datasource.local.models.CharacterEntity
import javax.inject.Inject

class CharactersLocalDataSourceImpl @Inject constructor(
    private val characterDao: CharacterDao
): CharactersLocalDataSource {
    override suspend fun getCharacters(): List<CharacterEntity> {
        return characterDao.getCharacters()
    }

    override suspend fun insertCharacter(characterEntity: CharacterEntity) {
        characterDao.upsertCharacter(characterEntity)
    }
}