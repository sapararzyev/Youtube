package com.example.youtube.ui.fragment.internet

import com.example.youtube.base.BaseFragment
import com.example.youtube.databinding.FragmentNullBinding
import com.example.youtube.ui.fragment.playlist.PlaylistModel


class NullFragment(override val viewModel: PlaylistModel)
    : BaseFragment<FragmentNullBinding, PlaylistModel, Any?>(FragmentNullBinding::inflate) {

    override fun initView() {
        val checkInternet = CheckInternet(requireContext())
        checkInternet.observe(this) { isConnected ->
            binding().btnNull.setOnClickListener {
                if (isConnected) {
                    controller.navigateUp()
                } } }

    }
    override fun initViewModel() {
       }
}