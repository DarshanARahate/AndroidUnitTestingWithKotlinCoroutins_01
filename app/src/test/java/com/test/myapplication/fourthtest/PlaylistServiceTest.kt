package com.test.myapplication.fourthtest

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.test.myapplication.utils.BaseUnitTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import java.lang.RuntimeException

class PlaylistServiceTest : BaseUnitTest() {

    private lateinit var service: PlaylistService
    private val api: PlaylistAPI = mock()
    private val playlists : List<Playlist> = mock()

    @Test
    fun fetchPlaylistFromAPI() = runBlockingTest {
        service = PlaylistService(api)
        service.fetchPlaylists().first()
        verify(api, times(1)).fetchAllPlaylists()
    }

    @Test
    fun convertValuesToFlowResultAndEmitsThem() = runBlockingTest {
        mockSuccessfulCase()
        assertEquals(Result.success(playlists), service.fetchPlaylists().first())
    }

    @Test
    fun emitsErrorResultWhenNetworkFails() = runBlockingTest {
        mockErrorCase()
        assertEquals("Something went wrong.",
        service.fetchPlaylists().first().exceptionOrNull()?.message)
    }

    private suspend fun mockSuccessfulCase() {
        whenever(api.fetchAllPlaylists()).thenReturn(playlists)
        service = PlaylistService(api)
    }

    private fun mockErrorCase() {
        whenever(api.fetchAllPlaylists()).thenThrow(RuntimeException("Damn backend developers."))
        service = PlaylistService(api)
    }

}



 