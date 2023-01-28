package com.example.youtube.ui.fragment.details


import android.util.Log
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.FloatingWindow
import com.example.youtube.R
import com.example.youtube.base.BaseFragment
import com.example.youtube.databinding.FragmentPlayliasDetailsBinding
import com.example.youtube.model.Item
import com.example.youtube.model.Playlist
import com.example.youtube.model.Snippet
import com.example.youtube.ui.fragment.internet.CheckInternet
import com.example.youtube.ui.fragment.playlist.PlayListFragment
import com.example.youtube.ui.fragment.playlist.adapter.PlaylistAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PlayListDetailsFragment :
    BaseFragment<FragmentPlayliasDetailsBinding,
            PlayListDetailsViewModel,Snippet>(FragmentPlayliasDetailsBinding::inflate) {

    private lateinit var adapter: PlaylistDetailsAdapter
    private lateinit var coordinator : CoordinatorLayout.Behavior<FloatingActionButton>

    override val viewModel: PlayListDetailsViewModel by lazy {
        ViewModelProvider(this)[PlayListDetailsViewModel::class.java]
    }

    override fun initView() {
        val id = arguments?.getString(PlayListFragment.PLAYLIST_KEY)
        val title = arguments?.getString(PlayListFragment.PLAYLIST)
        viewModel.getPlaylistDetails(id.toString()).observe(viewLifecycleOwner) {
            Log.e("ololo", "initView:$it")
            it.items.let { it1 -> adapter.getList(it1)  }
            binding().tvDetails.text = title.toString()
        }
    }
    override fun initViewModel() {
        adapter = PlaylistDetailsAdapter()
            binding().rvDetails.adapter = adapter
    }
}