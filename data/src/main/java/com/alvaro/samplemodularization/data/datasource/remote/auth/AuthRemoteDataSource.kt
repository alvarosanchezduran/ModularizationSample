package com.alvaro.samplemodularization.data.datasource.remote.auth

import io.github.jan.supabase.auth.user.UserSession

interface AuthRemoteDataSource {
    suspend fun signIn(email: String, password: String): Result<Unit>
    suspend fun signUp(email: String, password: String): Result<Unit>
    suspend fun signOut(): Result<Unit>
    suspend fun isUserLogged(): Result<UserSession>
}