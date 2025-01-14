package com.alvaro.samplemodularization.domain.usecases.auth

import com.alvaro.samplemodularization.domain.repositories.AuthRepository
import javax.inject.Inject

class SignOutAuthUseCase @Inject constructor (
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): Boolean {
        return authRepository.signOut().isSuccess
    }
}