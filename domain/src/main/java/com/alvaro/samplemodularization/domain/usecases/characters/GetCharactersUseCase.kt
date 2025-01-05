package com.alvaro.samplemodularization.domain.usecases.characters

import com.alvaro.samplemodularization.domain.models.Character
import com.alvaro.samplemodularization.domain.repositories.CharactersRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor (
    private val charactersRepository: CharactersRepository
) {
    suspend operator fun invoke(): List<Character> {
        return charactersRepository.getCharacters()
    }
}