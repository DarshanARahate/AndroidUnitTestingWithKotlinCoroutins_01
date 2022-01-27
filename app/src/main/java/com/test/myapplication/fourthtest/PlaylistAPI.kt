package com.test.myapplication.fourthtest

class PlaylistAPI {

    fun fetchAllPlaylists() : List<PlaylistRaw> {
       return mutableListOf<PlaylistRaw>(
           PlaylistRaw("ID_1", "Ashwini", "Teacher" ),
           PlaylistRaw("ID_2", "Aditya", "Manager" ),
           PlaylistRaw("ID_3", "Ananya", "Teacher" ),
           PlaylistRaw("ID_4", "Darshan", "Developer" ),
           PlaylistRaw("ID_5", "Arun", "Businessman" ),
           PlaylistRaw("ID_6", "Ratna", "Housewife"))
    }
}