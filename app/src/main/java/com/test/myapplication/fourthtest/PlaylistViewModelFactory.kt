package com.test.myapplication.fourthtest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PlaylistViewModelFactory(
    private val respository: PlaylistRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlaylistViewModel(respository) as T
    }


}