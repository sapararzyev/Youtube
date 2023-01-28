package com.example.youtube.ui.fragment.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.databinding.ItemPlaylistBinding
import com.example.youtube.model.Item
import com.example.youtube.utils.loadImage

class PlaylistDetailsAdapter:RecyclerView.Adapter<PlaylistDetailsAdapter.PlaylistDetailsViewHolder>() {

    private var list: ArrayList<Item> = arrayListOf()

    fun getList(lst: List<Item>){
        list.clear()
        list.addAll(lst)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistDetailsViewHolder {
        val binding = ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context))
        return PlaylistDetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaylistDetailsViewHolder, position: Int) {
        holder.onInit(list[position])
    }

    override fun getItemCount(): Int = list.size

   inner class PlaylistDetailsViewHolder(private val binding: ItemPlaylistBinding)
        :RecyclerView.ViewHolder(binding.root) {
        fun onInit(item: Item ) {
            binding.seriesTxt.text = item.snippet?.publishedAt
            binding.titleTxt.text = item.snippet?.title
            binding.playlist.text = "${item.contentDetails?.itemCount}"
            binding.playlistImg.loadImage(item.snippet?.thumbnails?.medium?.url.toString())
        }
   }
}