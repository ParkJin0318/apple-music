package com.parkjin.music.feature.listening

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parkjin.music.core.domain.model.Content
import com.parkjin.music.core.domain.usecase.ArchiveContentUseCase
import com.parkjin.music.core.domain.usecase.SearchContentsUseCase
import com.parkjin.music.core.domain.usecase.UnarchiveContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListeningViewModel @Inject constructor(
    private val searchContents: SearchContentsUseCase,
    private val archiveContent: ArchiveContentUseCase,
    private val unarchiveContent: UnarchiveContentUseCase,
) : ViewModel() {

    companion object {
        private const val Term = "greenday"
        private const val Entity = "song"
    }

    private val _state = MutableStateFlow(ListeningUIState())
    val state = _state.asStateFlow()

    private val currentState: ListeningUIState
        get() = state.value

    init {
        loadTracks()
    }

    fun archiveTrack(content: Content) {
        viewModelScope.launch {
            archiveContent(content)
        }
    }

    fun unarchiveTrack(content: Content) {
        viewModelScope.launch {
            unarchiveContent(content)
        }
    }

    private fun loadTracks() {
        searchContents(term = Term, entity = Entity, limit = 30, offset = 0)
            .onStart {
                updateState {
                    copy(isLoading = true)
                }
            }
            .onEach { tracks ->
                val copiedTracks = currentState.tracks
                    .associateBy { it.trackId }
                    .toMutableMap()

                copiedTracks.putAll(tracks.associateBy { it.trackId })

                updateState {
                    copy(tracks = copiedTracks.values.toList(), isLoading = false)
                }
            }.launchIn(viewModelScope)
    }

    private fun updateState(block: ListeningUIState.() -> ListeningUIState) {
        val newState = block(state.value)

        viewModelScope.launch {
            _state.emit(newState)
        }
    }
}
