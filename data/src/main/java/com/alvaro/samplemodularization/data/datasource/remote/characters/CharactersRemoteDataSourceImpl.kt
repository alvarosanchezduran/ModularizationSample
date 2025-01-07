package com.alvaro.samplemodularization.data.datasource.remote.characters

import com.alvaro.samplemodularization.data.datasource.remote.apis.StarWarsApi
import com.alvaro.samplemodularization.data.datasource.remote.models.CharacterDetailResponse
import com.alvaro.samplemodularization.data.datasource.remote.models.CharactersResponse
import retrofit2.HttpException
import javax.inject.Inject

class CharactersRemoteDataSourceImpl @Inject constructor(
    private val apiService: StarWarsApi
) : CharactersRemoteDataSource {
    override suspend fun getCharacters(): CharactersResponse {
            val response = apiService.getCharacters()
            if(!response.isSuccessful) throw HttpException(response)
            return response.body()!!
    }

    override suspend fun getCharacterDetail(id: String): CharacterDetailResponse {
        val response = apiService.getCharacterById(id.toInt())
        if(!response.isSuccessful) throw HttpException(response)
        return response.body()!!
    }
}