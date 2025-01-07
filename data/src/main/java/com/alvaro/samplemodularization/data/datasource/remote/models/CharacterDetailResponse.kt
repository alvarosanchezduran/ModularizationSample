package com.alvaro.samplemodularization.data.datasource.remote.models

import com.alvaro.samplemodularization.domain.models.CharacterDetail
import com.google.gson.annotations.SerializedName

data class CharacterDetailResponse(
    @SerializedName("result") val result: CharacterDetailDto
) {
    fun toDomain(): CharacterDetail {
        return CharacterDetail(
            result.properties.height,
            result.properties.mass,
            result.properties.hairColor,
            result.properties.skinColor,
            result.properties.eyeColor,
            result.properties.birthYear,
            result.properties.gender,
            result.properties.name
        )
    }
}
