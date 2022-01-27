package com.test.myapplication.fourthtest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.flow.onEach

class PlaylistViewModel(private val repository: PlaylistRepository) : ViewModel() {

    val playlists = liveData<Result<List<Playlist>>> {
        loader.postValue(true)
        emitSource(repository.getPlaylists()
            .onEach {
                loader.postValue(false)
            }
            .asLiveData())
    }

    val loader = MutableLiveData<Boolean>()
}