package com.test.myapplication.fourthtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.myapplication.R

class PlaylistFragment : Fragment() {

    lateinit var viewModel: PlaylistViewModel
    lateinit var viewModelFactory: PlaylistViewModelFactory
    private val mPlaylistAPI = PlaylistAPI()
    private val service = PlaylistService(mPlaylistAPI)
    private val respository = PlaylistRepository(service)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_playlist, container, false)
        setupViewModel()

        viewModel.playlists.observe(viewLifecycleOwner, {
            if (it.getOrNull() != null) {
                setupList(view, it.getOrNull()!!)
            } else {
                // TODO
            }
        })
        return view
    }

    private fun setupList(view: View?, playList: List<Playlist>) {
        with(view as RecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = MyPlaylistRecyclerViewAdapter(playList)
        }
    }

    private fun setupViewModel() {
        viewModelFactory = PlaylistViewModelFactory(respository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(PlaylistViewModel::class.java)

    }

    companion object {
        @JvmStatic
        fun newInstance() = PlaylistFragment().apply {  }
    }




}