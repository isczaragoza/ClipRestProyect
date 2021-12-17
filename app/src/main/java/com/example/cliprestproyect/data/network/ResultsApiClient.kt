package com.example.cliprestproyect.data.network

import com.example.cliprestproyect.data.model.ResultsModel
import retrofit2.Response
import retrofit2.http.GET

interface ResultsApiClient {

    @GET("api/")
    suspend fun getAllResults():Response<ResultsModel>;

}