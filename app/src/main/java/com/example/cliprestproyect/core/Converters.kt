package com.example.cliprestproyect.core

import androidx.room.TypeConverter
import com.example.cliprestproyect.data.model.Name
import com.example.cliprestproyect.data.model.Picture
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromName(name: Name): String {
        val gson = Gson()
        return gson.toJson(name)
    }

    @TypeConverter
    fun fromStringToName(value: String): Name {
        val stringType = object : TypeToken<Name>() {}.type
        return Gson().fromJson(value, stringType)
    }

    @TypeConverter
    fun fromPicture(picture: Picture): String {
        val gson = Gson()
        return gson.toJson(picture)
    }

    @TypeConverter
    fun fromStringToPicture(value: String): Picture {
        val stringType = object : TypeToken<Picture>() {}.type
        return Gson().fromJson(value, stringType)
    }

}