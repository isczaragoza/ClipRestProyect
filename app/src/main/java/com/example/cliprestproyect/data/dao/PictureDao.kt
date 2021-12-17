package com.example.cliprestproyect.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cliprestproyect.data.model.Picture

@Dao
interface PictureDao {

    @Insert
    fun insert(picture: Picture)

    @Query("SELECT * FROM Picture WHERE keyResult == :keyResult")
    fun getPictureByResult(keyResult: Int): Picture

    @Query("DELETE FROM Picture")
    fun deleteAll()

}