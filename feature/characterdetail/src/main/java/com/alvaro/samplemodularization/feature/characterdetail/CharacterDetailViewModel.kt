package com.alvaro.samplemodularization.feature.characterdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvaro.samplemodularization.core.di.navigation.StarWarsCharacterDetailScreenRoute
import com.alvaro.samplemodularization.domain.models.CharacterDetail
import com.alvaro.samplemodularization.domain.usecases.characters.GetCharacterDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val characterDetailUseCase: GetCharacterDetailUseCase
): ViewModel() {

    private val route = StarWarsCharacterDetailScreenRoute(savedStateHandle)
    private val id: String = route.id

    private val _character = MutableStateFlow<CharacterDetail?>(null)
    val character: StateFlow<CharacterDetail?> get() = _character

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    fun fetchCharacterDetail() {
        viewModelScope.launch {
            try {
                _loading.value = true
                _character.value = characterDetailUseCase(id)
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }
}