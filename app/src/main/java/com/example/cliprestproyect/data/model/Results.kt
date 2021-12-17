package com.example.cliprestproyect.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.cliprestproyect.core.Converters
import com.google.gson.annotations.SerializedName

@Entity
data class Results(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("key")
    val key : Long = 0,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    @TypeConverters(Converters::class)
    val name: Name,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("cell")
    val cell: String,
    @SerializedName("picture")
    @TypeConverters(Converters::class)
    val picture: Picture)