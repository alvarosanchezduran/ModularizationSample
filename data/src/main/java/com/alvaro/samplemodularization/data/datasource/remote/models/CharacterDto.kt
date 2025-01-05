package com.alvaro.samplemodularization.data.datasource.remote.models

import com.alvaro.samplemodularization.domain.models.Character
import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("uid") val uid: String,
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toDomain() = Character(uid, name)
}
