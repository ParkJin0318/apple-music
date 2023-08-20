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
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArchiveViewModel @Inject constructor(
    private val getArchivedContents: GetArchivedContentsUseCase,
    private val unarchiveContent: UnarchiveContentUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(ArchiveUIState())
    val state = _state.asStateFlow()

    private val currentState: ArchiveUIState
        get() = state.value

    init {
        val sections = listOf(ArchiveUISection.Header)
        _state.update { it.copy(sections = sections) }

        loadTracks()
    }

    fun unarchiveTrack(content: Content) {
        viewModelScope.launch {
            unarchiveContent(content)
        }
    }

    private fun loadTracks() {
        getArchivedContents()
            .onEach { handleTracks(it) }
            .launchIn(viewModelScope)
    }

    private fun handleTracks(tracks: List<Content>) {
        val sections = currentState.sections.toMutableList()
        sections.removeAll {
            it is ArchiveUISection.TrackItem ||
                it is ArchiveUISection.Empty
        }

        if (tracks.isEmpty()) {
            sections.add(ArchiveUISection.Empty)

            _state.update { it.copy(sections = sections) }
            return
        }

        sections.addAll(tracks.map(ArchiveUISection::TrackItem))

        _state.update { it.copy(sections = sections) }
    }
}
