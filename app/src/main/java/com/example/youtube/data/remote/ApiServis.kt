package com.example.youtube.data.remote

import com.example.youtube.model.Playlist
import com.example.youtube.BuildConfig
import com.example.youtube.objekt.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    fun getPlaylist(
        @Query("part") part:String = Constant.PART,
        @Query("channelId") channelId:String = Constant.CHANNEL_ID,
        @Query("maxResults") max:String = Constant.MAX_RESUTS,
        @Query("key") key:String = BuildConfig.API_KEY
        ):Call<Playlist>

    @GET("playlistItems")
    fun getPlaylistDetails(
        @Query("part") part:String = Constant.PART,
        @Query("playlistId")playlistId:String,
        @Query("maxResults") max:String = Constant.MAX_RESUTS,
        @Query("key") key:String = BuildConfig.API_KEY
        ):Call<Playlist>
}