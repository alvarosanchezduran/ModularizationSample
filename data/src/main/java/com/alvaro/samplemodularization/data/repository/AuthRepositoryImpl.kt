package com.alvaro.samplemodularization.data.repository

import com.alvaro.samplemodularization.data.datasource.remote.auth.AuthRemoteDataSource
import com.alvaro.samplemodularization.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource
): AuthRepository {
    override suspend fun signIn(email: String, password: String): Result<Unit> {
        return authRemoteDataSource.signIn(email, password)
    }

    override suspend fun signUp(email: String, password: String): Result<Unit> {
        return authRemoteDataSource.signUp(email, password)
    }

    override suspend fun signOut(): Result<Unit> {
        return authRemoteDataSource.signOut()
    }

    override suspend fun isUserLogged(): Boolean {
        return authRemoteDataSource.isUserLogged().isSuccess
    }
}