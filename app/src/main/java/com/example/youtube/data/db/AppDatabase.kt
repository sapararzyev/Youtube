package com.example.youtube.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.youtube.model.Playlist

@TypeConverters(Converter::class)
@Database(entities = [Playlist::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun dao():PlayListDao
}