package com.example.youtube.ui.fragment.playlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtube.data.remote.RetrofitClient
import com.example.youtube.model.Playlist
import com.example.youtube.base.BaseViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PlaylistModel : BaseViewModel() {
    private val apiService = RetrofitClient.create()

    fun getPlayList(): LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()

        apiService.getPlaylist().enqueue(object : Callback<Playlist> {
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if (response.isSuccessful ) {
                    data.value = response.body()
                }
                Log.e("-----------", "${response.body()}")
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                Log.e("ololo", "onFailure: " + t.message)
            }
        })
        return data
    }
}











