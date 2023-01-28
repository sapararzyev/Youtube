package com.example.youtube.ui.fragment.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtube.base.BaseViewModel
import com.example.youtube.data.remote.RetrofitClient
import com.example.youtube.model.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayListDetailsViewModel:BaseViewModel() {
  private  val apiService by lazy {
        RetrofitClient.create()
    }
    fun getPlaylistDetails(playlistId:String):LiveData<Playlist>{
        val data = MutableLiveData<Playlist>()
        apiService.getPlaylistDetails(playlistId = playlistId).enqueue(object : Callback<Playlist>{
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
               if (response.isSuccessful){
                data.value = response.body()
               }
            }
            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                Log.e("ololo", "onFailure:"+t.message )
            }

        })
        return data
    }
}