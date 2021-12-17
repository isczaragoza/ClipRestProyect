package com.example.cliprestproyect.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cliprestproyect.data.model.Name

@Dao
interface NameDao {

    @Insert
    fun insert(name: Name)

    @Query("SELECT * FROM Name WHERE keyResult = :keyResult")
    fun getNameByResult(keyResult: Int): Name

    @Query("DELETE FROM Name")
    fun deleteAll()

}