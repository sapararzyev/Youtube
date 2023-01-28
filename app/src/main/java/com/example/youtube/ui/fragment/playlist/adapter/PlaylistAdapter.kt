package com.example.youtube.ui.fragment.playlist.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.databinding.FragmentPlayliasDetailsBinding
import com.example.youtube.databinding.ItemPlaylistBinding
import com.example.youtube.model.Item
import com.example.youtube.utils.loadImage
import kotlin.reflect.KFunction2

class PlaylistAdapter(private val context: Context, private val onClik: (item: Item) -> Unit):
    RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    private var list: ArrayList<Item> = arrayListOf()

    fun setList(lst: List<Item>){
        list.clear()
        list.addAll(lst)
        notifyDataSetChanged()
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
     val binding = ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PlaylistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
       holder.onbind(list[position])
        holder.itemView.setOnClickListener {
            onClik(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class PlaylistViewHolder(private val binding: ItemPlaylistBinding)
        :RecyclerView.ViewHolder(binding.root) {
       fun onbind(item: Item) {
           binding.seriesTxt.text = item.snippet?.publishedAt
           binding.titleTxt.text = item.snippet?.title
           binding.playlist.text = "${item.contentDetails?.itemCount}"
           binding.playlistImg.loadImage(item.snippet?.thumbnails?.medium?.url.toString())
       }
   }
}