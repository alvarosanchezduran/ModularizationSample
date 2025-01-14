package com.alvaro.samplemodularization.domain.usecases.auth

import com.alvaro.samplemodularization.domain.models.Character
import com.alvaro.samplemodularization.domain.repositories.AuthRepository
import javax.inject.Inject

class SignInAuthUseCase @Inject constructor (
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Boolean {
        return authRepository.signIn(email, password).isSuccess
    }
}