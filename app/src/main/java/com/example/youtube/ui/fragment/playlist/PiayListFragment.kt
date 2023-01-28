package com.example.youtube.ui.fragment.playlist

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import com.example.youtube.R
import com.example.youtube.base.BaseFragment
import com.example.youtube.databinding.FragmentPlayListBinding
import com.example.youtube.model.Item
import com.example.youtube.ui.fragment.internet.CheckInternet
import com.example.youtube.ui.fragment.playlist.adapter.PlaylistAdapter

class PlayListFragment: BaseFragment<FragmentPlayListBinding, PlaylistModel, Any?>
    (FragmentPlayListBinding::inflate) {

    private lateinit var adapter : PlaylistAdapter
    override val viewModel: PlaylistModel by lazy {
        ViewModelProvider(this)[PlaylistModel::class.java]
    }

    @SuppressLint("ResourceType")
    override fun initView() {
        initAdapter()
        val checkInternet = CheckInternet(requireContext())
        checkInternet.observe(this){ isConnected ->
            if (!isConnected){
                controller.navigate(R.id.nullFragment)
            }
        }
    }
    override fun initViewModel() {
    viewModel.getPlayList().observe(viewLifecycleOwner,){
    Log.e("ololo", "initViewModel: $it")
        it.items.let { it1-> adapter.setList(it1)  }
   }}
    private fun initAdapter(){
        adapter = PlaylistAdapter(requireContext(),this::onItemClik)
        binding().rvItemPlay.adapter = adapter
    }
    private fun onItemClik(item: Item){
        controller.navigate(R.id.playListDetailsFragment,
            bundleOf(PLAYLIST_KEY to item.id , PLAYLIST to item.snippet?.title))
    }
    companion object{
        const val PLAYLIST_KEY = "key.id.playlist"
        const val PLAYLIST = "key.item.title"
    }
}