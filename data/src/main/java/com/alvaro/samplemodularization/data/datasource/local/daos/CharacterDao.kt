package com.alvaro.samplemodularization.data.datasource.local.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.alvaro.samplemodularization.data.datasource.local.models.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {
    @Query("SELECT * FROM characters")
    suspend fun getCharacters(): List<CharacterEntity>

    @Upsert
    suspend fun upsertCharacter(character: CharacterEntity)
}