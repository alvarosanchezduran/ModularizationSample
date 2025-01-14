package com.alvaro.samplemodularization.domain.usecases.auth

import com.alvaro.samplemodularization.domain.repositories.AuthRepository
import javax.inject.Inject

class SignUpAuthUseCase @Inject constructor (
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Boolean {
        return authRepository.signUp(email, password).isSuccess
    }
}