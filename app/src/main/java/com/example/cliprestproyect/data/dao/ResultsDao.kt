package com.example.cliprestproyect.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cliprestproyect.data.model.Results

@Dao
interface ResultsDao {

    @Insert
    fun insert(result: Results)

    @Query("SELECT * FROM Results")
    fun getAllResults(): List<Results>

    @Query("DELETE FROM Results")
    fun deleteAll()

}