package com.alvaro.samplemodularization.domain.usecases.characters

import com.alvaro.samplemodularization.domain.models.CharacterDetail
import com.alvaro.samplemodularization.domain.repositories.CharactersRepository
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor (
    private val charactersRepository: CharactersRepository
) {
    suspend operator fun invoke(id: String): CharacterDetail {
        return charactersRepository.getCharacterDetail(id)
    }
}