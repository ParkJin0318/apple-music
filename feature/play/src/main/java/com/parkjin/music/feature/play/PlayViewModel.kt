package com.parkjin.music.feature.play

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parkjin.music.core.domain.usecase.GetGreenDaySongsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayViewModel @Inject constructor(
    private val getGreenDaySongs: GetGreenDaySongsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(PlayState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val songs = getGreenDaySongs(limit = 30, offset = 0)

            updateState {
                copy(
                    isLoading = false,
                    songs = songs,
                )
            }
        }
    }

    private fun updateState(block: PlayState.() -> PlayState) {
        val newState = block(state.value)

        viewModelScope.launch {
            _state.emit(newState)
        }
    }
}
