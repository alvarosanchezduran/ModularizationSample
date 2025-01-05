package com.alvaro.samplemodularization.data.datasource.remote.apis

import com.alvaro.samplemodularization.data.datasource.remote.models.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET

interface StarWarsApi {
    @GET("people")
    suspend fun getCharacters(): Response<CharactersResponse>
    /*@GET("people/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Response<>*/
}