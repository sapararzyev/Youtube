package com.example.youtube.data.db

import androidx.room.TypeConverter
import com.example.youtube.model.Item
import com.example.youtube.model.PageInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object Converter {
    val gson = Gson()

    @TypeConverter
    fun jsonToItems(data:String):List<Item>{
        val listType: Type = object :TypeToken<List<Item>>(){}.type
                return gson.fromJson(data,listType)
    }

    @TypeConverter
    fun itemsString(items:List<Item>):String{
     return gson.toJson(items)
    }

    @TypeConverter
    fun pageToString(pageInfo: PageInfo):String{
        return gson.toJson(pageInfo)
    }

    @TypeConverter
    fun jsonToPageInfo(data:String):PageInfo{
        return gson.fromJson(data,PageInfo::class.java)
    }
}