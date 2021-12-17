package com.example.cliprestproyect.data.network

import com.example.cliprestproyect.data.model.ResultsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ResultsService @Inject constructor(private val api : ResultsApiClient){

    suspend fun getResults(): ResultsModel? {
        return withContext(Dispatchers.IO) {
            val response: Response<ResultsModel> =
                api.getAllResults();
            response.body();
        }
    }

}