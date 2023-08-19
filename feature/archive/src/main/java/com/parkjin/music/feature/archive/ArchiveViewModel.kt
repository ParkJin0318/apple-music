package com.parkjin.music.feature.archive

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parkjin.music.core.domain.model.Content
import com.parkjin.music.core.domain.usecase.GetArchivedContentsUseCase
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
class ArchiveViewModel @Inject constructor(
    private val getArchivedContents: GetArchivedContentsUseCase,
    private val unarchiveContent: UnarchiveContentUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(ArchiveUIState())
    val state = _state.asStateFlow()

    init {
        loadTracks()
    }

    fun unarchiveTrack(content: Content) {
        viewModelScope.launch {
            unarchiveContent(content)
        }
    }

    private fun loadTracks() {
        getArchivedContents()
            .onStart {
                updateState {
                    copy(isLoading = true)
                }
            }
            .onEach { tracks ->
                updateState {
                    copy(tracks = tracks, isLoading = false)
                }
            }.launchIn(viewModelScope)
    }

    private fun updateState(block: ArchiveUIState.() -> ArchiveUIState) {
        val newState = block(state.value)

        viewModelScope.launch {
            _state.emit(newState)
        }
    }
}
