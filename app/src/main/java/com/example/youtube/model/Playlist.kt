package com.example.youtube.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Playlist(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var etag: String?, // JI-7FxA40_IV0plA3qCD1zftLEQ
    var items: List<Item>,
    var kind: String?, // youtube#playlistListResponse
    var nextPageToken: String?, // CAoQAA
    var pageInfo: PageInfo?
)