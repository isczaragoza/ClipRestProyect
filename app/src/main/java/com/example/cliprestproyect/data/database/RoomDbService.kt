package com.example.cliprestproyect.data.database

import android.content.Context
import com.example.cliprestproyect.data.dao.NameDao
import com.example.cliprestproyect.data.dao.PictureDao
import com.example.cliprestproyect.data.dao.ResultsDao
import com.example.cliprestproyect.data.model.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class RoomDbService(context: Context) {

    private val roomDb: RoomDb = RoomDb.getDatabase(context)!!;
    private val resultsDao : ResultsDao= roomDb.resultsDao();
    private val pictureDao : PictureDao = roomDb.pictureDao();
    private val nameDao : NameDao = roomDb.nameDao();

    suspend fun insertResult(result :Results){
        withContext(Dispatchers.IO){
            resultsDao.insert(result)
        }
    }

    suspend fun getResultsFromDb(): List<Results>{
        return withContext(Dispatchers.IO) {
            resultsDao.getAllResults();
        }
    }

    suspend fun deleteResultsFromDb() {
        withContext(Dispatchers.IO) {
            resultsDao.deleteAll();
        }
    }

}