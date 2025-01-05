package com.alvaro.samplemodularization.data.datasource.remote.models

import com.alvaro.samplemodularization.domain.models.Character
import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("results") val results: List<CharacterDto>
) {
    fun toDomain(): List<Character> {
        return results.map { it.toDomain() }
    }
}
