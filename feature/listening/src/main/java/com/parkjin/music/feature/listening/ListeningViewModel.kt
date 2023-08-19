package com.parkjin.music.feature.listening

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parkjin.music.core.domain.model.Content
import com.parkjin.music.core.domain.usecase.GetGreenDayTracksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListeningViewModel @Inject constructor(
    private val getGreenDayTracks: GetGreenDayTracksUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(ListeningUIState())
    val state = _state.asStateFlow()

    private val currentState: ListeningUIState
        get() = state.value

    init {
        viewModelScope.launch {
            updateState {
                copy(isLoading = true)
            }

            val tracks = getGreenDayTracks(limit = 30, offset = 0)
            val uiModels = currentState.uiModels.toMutableList()

            uiModels.add(ListeningUIModel.Header)
            uiModels.addAll(tracks.map { ListeningUIModel.Track(it, false) })

            updateState {
                copy(
                    isLoading = false,
                    uiModels = uiModels,
                )
            }
        }
    }

    fun addToArchive(content: Content) {
        // TODO
    }

    fun removeToArchive(content: Content) {
        // TODO
    }

    private fun updateState(block: ListeningUIState.() -> ListeningUIState) {
        val newState = block(state.value)

        viewModelScope.launch {
            _state.emit(newState)
        }
    }
}
