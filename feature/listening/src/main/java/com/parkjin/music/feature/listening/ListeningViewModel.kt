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
import kotlinx.coroutines.flow.update
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
        private const val Limit = 30
    }

    private val _state = MutableStateFlow(ListeningUIState())
    val state = _state.asStateFlow()

    private val currentState: ListeningUIState
        get() = state.value

    init {
        val sections = listOf(ListeningUISection.Header)
        _state.update { it.copy(sections = sections) }

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

    fun loadTracks() {
        val sections = currentState.sections.toMutableList()

        if (sections.contains(ListeningUISection.Loading)) return
        sections.add(ListeningUISection.Loading)

        _state.update { it.copy(sections = sections) }

        searchContents(term = Term, entity = Entity, limit = Limit, offset = currentState.offset)
            .onEach { handleTracks(it) }
            .launchIn(viewModelScope)
    }

    private fun handleTracks(tracks: List<Content>) {
        val sections = currentState.sections.toMutableList()
        sections.removeAll {
            it is ListeningUISection.TrackItem ||
                it is ListeningUISection.Empty ||
                it is ListeningUISection.Loading
        }

        if (tracks.isEmpty()) {
            sections.add(ListeningUISection.Empty)

            _state.update { it.copy(sections = sections) }
            return
        }

        val mergedTracks = mergeTracks(tracks)
        sections.addAll(mergedTracks.map(ListeningUISection::TrackItem))

        _state.update {
            it.copy(
                offset = it.offset.plus(tracks.size),
                sections = sections,
            )
        }
    }

    private fun mergeTracks(tracks: List<Content>): List<Content> {
        val copiedTracks = currentState.sections
            .filterIsInstance<ListeningUISection.TrackItem>()
            .map { it.track }
            .associateBy { it.trackId }
            .toMutableMap()

        copiedTracks.putAll(tracks.associateBy { it.trackId })
        return copiedTracks.values.toList()
    }
}
