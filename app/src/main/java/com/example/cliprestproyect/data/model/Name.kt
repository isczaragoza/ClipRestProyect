package com.example.cliprestproyect.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Name(
    @PrimaryKey
    val keyResult: Int,
    @SerializedName("title") val title: String, @SerializedName("first") val first: String,
    @SerializedName("last") val last: String
) {
}