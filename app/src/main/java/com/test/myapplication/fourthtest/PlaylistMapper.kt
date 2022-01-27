package com.test.myapplication.fourthtest

import com.test.myapplication.R
import javax.inject.Inject

class PlaylistMapper @Inject constructor()
    : Function1<List<PlaylistRaw>, List<Playlist>>{

    override fun invoke(playlistsRaw: List<PlaylistRaw>): List<Playlist> {
        return playlistsRaw.map {
            val image = when(it.category) {
                "Teacher" -> R.mipmap.ic_launcher
                else -> R.mipmap.ic_launcher_round
            }
            Playlist(it.id, it.name, it.category, image)
        }
    }
}