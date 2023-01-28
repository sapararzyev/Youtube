package com.example.youtube.model

data class Item(
    var contentDetails: ContentDetails?,
    var etag: String?, // ES2XeEJHJlOc-3x3KmHdJR9gQ5w
    var id: String?, // PL0hlAxbZ3avBt-DAtTIvYGZrUWISuvJpu
    var kind: String?, // youtube#playlist
    var snippet: Snippet?
)