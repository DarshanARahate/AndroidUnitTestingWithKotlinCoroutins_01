package com.test.myapplication.fourthtest

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.test.myapplication.utils.BaseUnitTest
import com.test.myapplication.utils.captureValues
import com.test.myapplication.utils.getValueForTest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test
import java.lang.RuntimeException

class PlaylistViewModelTest : BaseUnitTest() {

    private val repository = mock<PlaylistRepository>()
    private val playlists = mock<List<Playlist>>()
    private val expected = Result.success(playlists)
    private val exception = RuntimeException("Something went wrong")

    @Test
    fun getPlaylistFromRepository() = runBlockingTest {
        val viewModel = mockSuccessfulCase()
        viewModel.playlists.getValueForTest()
        verify(repository, times(1)).getPlaylists()
    }

    @Test
    fun emitsPlaylistsFromRepository() = runBlockingTest {
        val viewModel = mockSuccessfulCase()
        assertEquals(expected, viewModel.playlists.getValueForTest())
    }

    @Test
    fun emitErrorWhenReceiveError() {
        val playlistViewModel = mockFailureCase()
        assertEquals(exception, playlistViewModel.playlists.getValueForTest()!!.exceptionOrNull())
    }

    @Test
    fun showSpinnerWhileLoading() = runBlockingTest {
        val viewModel = mockSuccessfulCase()
        viewModel.loader.captureValues {
            viewModel.playlists.getValueForTest()
            assertEquals(true, values[0])
        }
    }

    @Test
    fun closeLoaderAfterPlaylistsLoad() = runBlockingTest {
        val viewModel = mockSuccessfulCase()
        viewModel.loader.captureValues {
            viewModel.playlists.getValueForTest()
            assertEquals(false, values.last())
        }
    }

    @Test
    fun closeLoaderAfterError() = runBlockingTest {
        val viewModel = mockFailureCase()
        viewModel.loader.captureValues {
            viewModel.playlists.getValueForTest()
            assertEquals(false, values.last())
        }
    }

    private fun mockSuccessfulCase() : PlaylistViewModel {
        runBlockingTest {
            whenever(repository.getPlaylists()).thenReturn(
                flow {
                    emit(expected)
                }
            )
        }
        return PlaylistViewModel(repository)
    }

    private fun mockFailureCase() : PlaylistViewModel {
        runBlockingTest {
            whenever(repository.getPlaylists()).thenReturn(
                flow {
                    emit(Result.failure<List<Playlist>>(exception))
                }
            )
        }
        return PlaylistViewModel(repository)
    }

}