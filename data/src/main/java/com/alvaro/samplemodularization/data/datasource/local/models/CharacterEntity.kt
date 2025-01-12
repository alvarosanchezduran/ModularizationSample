package com.alvaro.samplemodularization.data.datasource.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alvaro.samplemodularization.domain.models.Character

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey val uid: String,
    val name: String,
    val url: String
) {
    fun toDomain(): Character {
        return Character(
            this.uid,
            this.name
        )
    }
}