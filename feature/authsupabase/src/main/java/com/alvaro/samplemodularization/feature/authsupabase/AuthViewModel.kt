package com.alvaro.samplemodularization.feature.authsupabase

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvaro.samplemodularization.domain.models.Character
import com.alvaro.samplemodularization.domain.repositories.AuthRepository
import com.alvaro.samplemodularization.domain.usecases.auth.SignInAuthUseCase
import com.alvaro.samplemodularization.domain.usecases.auth.SignOutAuthUseCase
import com.alvaro.samplemodularization.domain.usecases.auth.SignUpAuthUseCase
import com.alvaro.samplemodularization.domain.usecases.characters.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.sign

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signInAuthUseCase: SignInAuthUseCase,
    private val signOutAuthUseCase: SignOutAuthUseCase,
    private val signUpAuthUseCase: SignUpAuthUseCase,
    private val authRepository: AuthRepository
): ViewModel() {

    private val _isUserLogged = MutableStateFlow(true)
    val isUserLogged: StateFlow<Boolean> get() = _isUserLogged

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    init {
        isUserLogged()
    }

    private fun isUserLogged() {
        viewModelScope.launch {
            try {
                _loading.value = true
                delay(1000)
                _isUserLogged.value = authRepository.isUserLogged()
                Log.i("ALVARO", "isUserLogged: ${_isUserLogged.value}º")
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            try {
                _loading.value = true
                val signin = signInAuthUseCase(email, password)
                if(signin) isUserLogged()
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }

    fun signOut() {
        viewModelScope.launch {
            try {
                _loading.value = true
                signOutAuthUseCase()
                isUserLogged()
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }

    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            try {
                signUpAuthUseCase(email, password)
                isUserLogged()
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }
}