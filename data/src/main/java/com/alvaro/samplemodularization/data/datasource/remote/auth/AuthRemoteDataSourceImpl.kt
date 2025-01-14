package com.alvaro.samplemodularization.data.datasource.remote.auth

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.user.UserInfo
import io.github.jan.supabase.auth.user.UserSession
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    val authClient: SupabaseClient
): AuthRemoteDataSource {
    override suspend fun signIn(email: String, password: String): Result<Unit> {
        return try {
            authClient.auth.signInWith(Email) {
                this.email = email
                this.password = password
            }
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signUp(email: String, password: String): Result<Unit> {
        return try {
            authClient.auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signOut(): Result<Unit> {
        return try {
            authClient.auth.signOut()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun isUserLogged(): Result<UserSession> {
        return try {
            val user = authClient.auth.currentSessionOrNull()
            user?.let {
                Result.success(it)
            } ?: kotlin.run {
                Result.failure(Exception("User not logged"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}