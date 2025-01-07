package com.alvaro.samplemodularization.data.datasource.remote.models

import com.google.gson.annotations.SerializedName

data class CharacterDetailDto(
    val properties: Properties
)

data class Properties(
    val height: String,
    val mass: String,
    @SerializedName("hair_color") val hairColor: String,
    @SerializedName("skin_color") val skinColor: String,
    @SerializedName("eye_color") val eyeColor: String,
    @SerializedName("birth_year") val birthYear: String,
    val gender: String,
    val created: String,
    val edited: String,
    val name: String,
    val homeworld: String,
    val url: String
)