package com.tizzone.albumapp.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tizzone.albumapp.domain.data.TrackViewState
import com.tizzone.albumapp.domain.usecases.GetTracks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel
@Inject constructor(
    private val getAlbumTitles: GetTracks
) : ViewModel() {
    fun init() {
        fetchAllAlbums()
    }

    private var _state = MutableStateFlow(TrackViewState(isLoading = false))
    val state: StateFlow<TrackViewState> get() = _state
    private fun fetchAllAlbums() {
        viewModelScope.launch {
            getAlbumTitles()
                .collect {
                    titlesState ->
                    _state.value = titlesState
                }
        }
    }
}
