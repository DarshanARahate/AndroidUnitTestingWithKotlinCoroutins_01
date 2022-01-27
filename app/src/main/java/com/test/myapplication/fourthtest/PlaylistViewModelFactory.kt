package com.test.myapplication.fourthtest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class PlaylistViewModelFactory @Inject constructor(
    private val respository: PlaylistRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlaylistViewModel(respository) as T
    }

}