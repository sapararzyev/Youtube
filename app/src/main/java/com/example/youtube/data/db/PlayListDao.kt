package com.example.youtube.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.youtube.model.Playlist

@Dao
interface PlayListDao {
    @Insert
    fun insert(playlist: Playlist)
    @Query("SELECT * FROM playlist")
    fun getPlaylist():Playlist
}