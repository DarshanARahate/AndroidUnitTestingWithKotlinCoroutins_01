package com.test.myapplication.fourthtest

import com.test.myapplication.R
import com.test.myapplication.utils.BaseUnitTest
import junit.framework.TestCase.assertEquals
import org.junit.Test

class PlaylistMapperTest : BaseUnitTest() {

    private val playlistRaw = PlaylistRaw("ID_1", "Ashwini", "anTeacher")
    private val playlistRawTeacher = PlaylistRaw("ID_1", "Ashwini", "Teacher")

    private val mapper = PlaylistMapper()

    private val playlists = mapper(listOf(playlistRaw))

    private val playlist = playlists[0]
    private val playlistRock = mapper(listOf(playlistRawTeacher))[0]

    @Test
    fun keepSameId() {
        assertEquals(playlistRaw.id, playlist.id)
    }

    @Test
    fun keepSameName() {
        assertEquals(playlistRaw.name, playlist.name)
    }

    @Test
    fun keepSameCategory() {
        assertEquals(playlistRaw.category, playlist.category)
    }

    @Test
    fun mapDefaultImageWhenNoTeacher() {
        assertEquals(R.mipmap.ic_launcher_round, playlist.image)
    }

    @Test
    fun mapDefaultImageWhenTeacherCategory() {
        assertEquals(R.mipmap.ic_launcher, playlistRock.image)
    }
}