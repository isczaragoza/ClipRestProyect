package com.example.cliprestproyect.data

import android.app.Application
import android.content.Context
import com.example.cliprestproyect.data.database.RoomDbService
import com.example.cliprestproyect.data.model.Results
import com.example.cliprestproyect.data.model.ResultsModel
import com.example.cliprestproyect.data.model.ResultsProvider
import com.example.cliprestproyect.data.network.ResultsService
import javax.inject.Inject

class ResultsRepository @Inject constructor(private val context: Application, private val api : ResultsService) {

    private val roomService = RoomDbService(context);

    suspend fun getRoomResults(): List<Results> {
        val results: List<Results> = roomService.getResultsFromDb();
        return results;
    }

    suspend fun insertRoomResults(result: Results) {
        roomService.insertResult(result);
    }

    suspend fun deleteRoomAllResults(){
        roomService.deleteResultsFromDb();
    }

    suspend fun requestApiResults(): ResultsModel? {
        val response: ResultsModel? = api.getResults();
        //ResultsProvider.results = response;
        return response;
    }



}