package com.test.myapplication.fourthtest

import com.test.myapplication.R

class PlaylistAPI {

    fun fetchAllPlaylists() : List<Playlist> {
       return mutableListOf<Playlist>(
                    Playlist("ID_1", "Ashwini", "Teacher", R.drawable.ic_launcher_foreground),
                    Playlist("ID_2", "Aditya", "Manager", R.drawable.ic_launcher_foreground),
                    Playlist("ID_3", "Ananya", "Student", R.drawable.ic_launcher_foreground),
                    Playlist("ID_4", "Darshan", "Developer", R.drawable.ic_launcher_foreground),
                    Playlist("ID_5", "Arun", "Businessman", R.drawable.ic_launcher_foreground),
                    Playlist("ID_6", "Ratna", "Housewife", R.drawable.ic_launcher_foreground))
    }
}